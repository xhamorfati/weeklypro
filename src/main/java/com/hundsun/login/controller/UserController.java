package com.hundsun.login.controller;

import com.hundsun.login.bean.CommonReturnType;
import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.login.dataobject.UserDO;
import com.hundsun.login.dataobject.UserPasswordDO;
import com.hundsun.login.error.BussinessException;
import com.hundsun.login.error.EmBusinessError;
import com.hundsun.login.service.UserService;

import com.hundsun.login.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
//@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    //单例 内部threadLocal
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/login")
    public String testHomepage() {
        //在没有配置的情况下，return "login”会到templates/login.html去。
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",false);
        if (this.httpServletRequest.getSession().getAttribute("LOGIN_USER")!= null){
            this.httpServletRequest.getSession().removeAttribute("LOGIN_USER");
        }
        return "login";
    }

    /**
     * 用户登录接口
     * @param domainId
     * @param password
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name="domainId")String domainId,
                                  @RequestParam(name="password")String password) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        UserModel userModel =new UserModel();
        userModel =userService.validateLogin(domainId,this.enCodeByMD5(password));

        //将登陆凭证加入到用户登陆成功的session中
        UserVo userVo = convertFromMode(userModel);
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userVo);

//        System.out.println(this.httpServletRequest.getSession().getAttribute("IS_LOGIN"));
        return CommonReturnType.create(userVo);
    }

    /**
     * 获取当前登录的用户
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/getuser")
    @ResponseBody
    public CommonReturnType getCurrentUser() throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        return CommonReturnType.create(userVo);
    }

    /**
     * 管理员界面查询用户
     * @param workId
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/getallusers", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getAllUsers(@RequestParam(name="workId", required = false)String workId) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserVo current_userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        List<UserModel> userModelList =new ArrayList<>();
        List<UserVo> userVoList =new ArrayList<>();
        if("admin".equals(current_userVo.getReserve1())){
            if(workId == null || workId == ""){
                userModelList = userService.getAllByWorkId(null);
            }
            else{
                userModelList = userService.getAllByWorkId(workId);
            }
            if(userModelList == null){
                return CommonReturnType.create(null);
            }
            else{
                for(UserModel userModel:userModelList){
                    UserVo userVo = convertFromMode(userModel);
                    userVoList.add(userVo);
                }
            }
        }
        else {
            userVoList = null;
        }

        return CommonReturnType.create(userVoList);
    }


    /**
     * 管理员删除用户
     * @param domainId
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/deleteuser", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteUserByDomainId(@RequestParam(name="domainId", required = true)String domainId) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserVo current_userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        List<UserModel> userModelList =new ArrayList<>();
        List<UserVo> userVoList =new ArrayList<>();
        if("admin".equals(current_userVo.getReserve1())){
            userService.deleteByDomainId(domainId);
        }
        return CommonReturnType.create(null);
    }

    /**
     * 用户编辑
     * @param domainId
     * @param workId
     * @param name
     * @param gender
     * @param emailAddress
     * @param reserve1
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/edituser", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType editUserByDomainId(@RequestParam(name="domainId", required = true)String domainId,
                                               @RequestParam(name="workId", required = false)String workId,
                                               @RequestParam(name="name", required = false)String name,
                                               @RequestParam(name="gender", required = false)String gender,
                                               @RequestParam(name="emailAddress", required = false)String emailAddress,
                                               @RequestParam(name="reserve1", required = false)String reserve1,
                                               @RequestParam(name="reserve2", required = false)String reserve2,
                                               @RequestParam(name="reserve3", required = false)String reserve3) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        UserDO userDO = new UserDO();
        userDO.setDomainId(domainId);
        userDO.setName(name);
        userDO.setWorkId(workId);
        userDO.setGender(gender);
        userDO.setEmailAddress(emailAddress);
        userDO.setReserve1(reserve1);
        userDO.setReserve2(reserve2);
        userDO.setReserve3(reserve3);
        userService.updatebyDomainId( userDO);
        return CommonReturnType.create(null);
    }

    /**
     * 验证旧密码是否正确
     * @param password
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/verifiyCurrentPsw", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType verifiyCurrentPsw(@RequestParam(name="password", required = true)String password) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String oldencrptpsw = enCodeByMD5(password);
        UserVo current_userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        String domainId = current_userVo.getDomainId();
        userService.validateLogin(domainId,oldencrptpsw);
        return CommonReturnType.create(null);
    }

    /**
     * 更新新密码
     * @param password
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/updateCurrentPsw", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateCurrentPsw(@RequestParam(name="renewpassword", required = true)String password) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserVo current_userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setDomainId(current_userVo.getDomainId());
        userPasswordDO.setEncrptPassword(enCodeByMD5(password));
        userService.updatePassword(userPasswordDO);
        return CommonReturnType.create(null);
    }

    /**
     * 新增用户或者用户注册接口
     * @param domainId
     * @param workId
     * @param name
     * @param emailAddress
     * @param reserve1
     * @param gender
     * @param password
     * @return
     * @throws BussinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @Transactional
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "domainId") String domainId,
                                     @RequestParam(name = "workId") String workId,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "gender") String gender,
                                     @RequestParam(name = "emailAddress") String emailAddress,
                                     @RequestParam(name = "reserve1") String reserve1,
                                     @RequestParam(name = "reserve2") String reserve2,
                                     @RequestParam(name = "reserve3") String reserve3,
                                     @RequestParam(name="password" , required = false )String password ) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        //用户注册流程
        UserModel userModel = new UserModel();
        userModel.setDomainId(domainId);
        userModel.setWorkId(workId);
        userModel.setName(name);
        userModel.setGender(gender);
        userModel.setEmailAddress(emailAddress);
        userModel.setReserve1(reserve1);
        userModel.setReserve2(reserve2);
        userModel.setReserve3(reserve3);
        userModel.setEncrptPassword(this.enCodeByMD5("111111"));

        userService.register(userModel);
        return CommonReturnType.create(null);

    }


    public String enCodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 加密字符串
        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
//        System.out.println("加密密码为："+newStr);
        return newStr;
    }

    private UserVo convertFromMode(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel, userVo);
        return userVo;
    }

}

