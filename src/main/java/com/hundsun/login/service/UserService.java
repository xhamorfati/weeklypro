package com.hundsun.login.service;

import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.login.dataobject.UserDO;
import com.hundsun.login.dataobject.UserPasswordDO;
import com.hundsun.login.error.BussinessException;
import com.hundsun.login.service.model.UserModel;

import java.util.List;

public interface UserService {


    UserModel getByDomainId(String domainId);
    void register(UserModel userModel) throws BussinessException;
    void deleteByDomainId(String domainId) throws BussinessException;
    void updatebyDomainId(UserDO userDO)throws BussinessException;
    void updatePassword(UserPasswordDO userPasswordDO)throws BussinessException;

    /**
     * 登陆验证
     * @param domainId 用户注册的手机
     * @param encrptPassword 用户加密后的密码
     */
    UserModel validateLogin(String domainId, String encrptPassword) throws BussinessException;
    List<UserModel> getAllByWorkId(String workId);

}
