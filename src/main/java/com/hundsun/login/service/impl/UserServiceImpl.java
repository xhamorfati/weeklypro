package com.hundsun.login.service.impl;

import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.login.dataobject.UserDO;
import com.hundsun.login.dataobject.UserPasswordDO;
import com.hundsun.login.error.BussinessException;
import com.hundsun.login.error.EmBusinessError;
import com.hundsun.login.mapper.UserDOMapper;
import com.hundsun.login.mapper.UserPasswordDOMapper;
import com.hundsun.login.service.UserService;
import com.hundsun.login.service.model.UserModel;
import com.hundsun.login.valiator.ValidationResult;
import com.hundsun.login.valiator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;
    @Autowired
    private ValidatorImpl validator;

    /**
     * 获取用户信息和密码
     * @param domainId
     * @return
     */
    @Override
    public UserModel getByDomainId(String domainId) {
        UserDO userDO = userDOMapper.findByDomainId(domainId);
        if(userDO == null){
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.findByDomainId(domainId);
        return convertFromDataObject(userDO,userPasswordDO);
    }

    @Override
    public List<UserModel> getAllByWorkId(String workId) {
        List<UserModel> userModelList =new ArrayList<>();
        List<UserDO> userDOList =new ArrayList<>();
        if(workId == null){
            userDOList = userDOMapper.findAll();
        }
        else{
            userDOList = userDOMapper.findAllByWorkId(workId);
        }
        if(userDOList == null){
            return null;
        }
        for (UserDO userDO:userDOList) {
            String domainId = userDO.getDomainId();
            UserPasswordDO userPasswordDO = userPasswordDOMapper.findByDomainId(domainId);
            userModelList.add(convertFromDataObject(userDO,userPasswordDO));
        }
        return userModelList;
    }

    /**
     * 新增用户
     * @param userModel
     * @throws BussinessException
     */
    @Transactional
    @Override
    public void register(UserModel userModel) throws BussinessException {
        if(userModel == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ValidationResult result = validator.validate(userModel);
        System.out.println(result.getErrMsg()+"result");
        if (result.isHasErrors()) {
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }

        //实现model->dataobject方法
        UserDO userDO = convertFromModel(userModel);
        //使用insertSelective而不是insert,insertSelective会将对象为null的字段不进行插入，使这个字段依赖数据库的默认值。
        try {
            userDOMapper.insert(userDO);
        } catch (DuplicateKeyException e) {
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"该用户已注册！");
        }
        userModel.setDomainId(userDO.getDomainId());

        UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel);
        userPasswordDOMapper.insert(userPasswordDO);
    }

    @Override
    public void deleteByDomainId(String domainId) throws BussinessException {
        if(domainId == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        else{
            if(!userDOMapper.deleteByDomainId(domainId)){
                throw new BussinessException(EmBusinessError.SQL_ERROR);
            }
            if(!userPasswordDOMapper.deleteByDomainId(domainId)){
                throw new BussinessException(EmBusinessError.SQL_ERROR);
            }
        }
    }

    @Override
    public void updatebyDomainId(UserDO userDo) throws BussinessException {
        if(userDo == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        else{
            if(!userDOMapper.updateByDomainId(userDo)){
                throw new BussinessException(EmBusinessError.SQL_ERROR);
            }
        }
    }

    @Override
    public void updatePassword(UserPasswordDO userPasswordDO) throws BussinessException {
        if(userPasswordDO == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        else{
            if(!userPasswordDOMapper.updatePassword(userPasswordDO)){
                throw new BussinessException(EmBusinessError.SQL_ERROR);
            }
        }
    }


    /**
     * 登录校验
     * @param domainId 用户注册的手机
     * @param encrptPassword 用户加密后的密码
     * @return
     * @throws BussinessException
     */
    @Override
    public UserModel validateLogin(String domainId, String encrptPassword) throws BussinessException {
        UserDO userDO = userDOMapper.findByDomainId(domainId);
        if(userDO == null) {
            throw new BussinessException(EmBusinessError.USER_NOT_EXIST);
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.findByDomainId(userDO.getDomainId());
        UserModel userModel = convertFromDataObject(userDO,userPasswordDO);
        //拿到用户信息内加密的密码是否和传输的是否相匹配
        if(!StringUtils.equals(encrptPassword,userModel.getEncrptPassword())){
            throw new BussinessException(EmBusinessError.USER_PASSWORD_ERROR);
        }
        return userModel;
    }



    /**
     * 从model中提取password
     * @param userModel
     * @return
     */
    private UserPasswordDO convertPasswordFromModel(UserModel userModel){
        if(userModel == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setDomainId(userModel.getDomainId());
        return userPasswordDO;
    }

    /**
     * 从model中提取userdo
     * @param userModel
     * @return
     */
    private UserDO convertFromModel(UserModel userModel){
        if(userModel == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;
    }

    /**
     * 将用户信息和密码组合成为model
     * @param userDO
     * @param userPasswordDO
     * @return
     */
    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
