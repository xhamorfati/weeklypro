package com.hundsun.login.controller;
import com.hundsun.login.bean.CommonReturnType;
import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.login.dataobject.WeeklyinfoDO;
import com.hundsun.login.dataobject.WeeklyinfoDOKey;
import com.hundsun.login.service.HomePageQryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class HomePageQryCotroller {
    @Autowired
    private HomePageQryService homePageQryService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/homepageqry")
    @ResponseBody
    public Object homePagery() throws ParseException {
        // 获取当前登录的用户名
        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        return CommonReturnType.create(homePageQryService.getWeeklyinfoByDomainId(userVo.getDomainId()));

    }

    @RequestMapping("/homepage")
    public String goHomepage() {
        //在没有配置的情况下，return "login”会到templates/login.html去。
        return "homepage";
    }

    @RequestMapping("/adminhomepage")
    public String goAdminHomepage() {
        return "adminhomepage";
    }
    @RequestMapping("/adminusermodify")
    public String goAdminUserModify() {
        return "adminusermodify";
    }

    @RequestMapping("/usermodify")
    public String goUserModify() {
        return "usermodify";
    }
//    @RequestMapping("/showinfomation")
//    public String goShowInfomation() {
//        return "showinfomation";
//    }
}
