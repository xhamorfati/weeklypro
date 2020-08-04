package com.hundsun.mailSender.controller;

import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.mailSender.dataobject.MailSenderInfoDO;
import com.hundsun.mailSender.service.impl.MailConfigImpl;
import com.hundsun.mailSender.service.impl.MailContentConfigimpl;
import com.hundsun.mailSender.service.impl.SimpleMailSender;
import com.hundsun.modelset.bean.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MailSenderController {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private SimpleMailSender sms;

    //邮件信息注入

    @RequestMapping( value="/getmailSenderConfig" )
    @ResponseBody
    public MailSenderInfoDO mailSenderConfig(@RequestParam(name = "domainId") String domainId) {
        MailConfigImpl mailconfig = new MailConfigImpl();
        //mailconfig.getMailConfigByDomainId(domainId);
        MailSenderInfoDO mailinfo = new MailSenderInfoDO();
        mailinfo.setMailServerHost("mail.hundsun.com");
        mailinfo.setMailServerPort("25");
        mailinfo.setValidate(true);
        //签名附件设置
        Map<String, String> imagesMap = new HashMap<>();
        imagesMap.put("logo", ".\\person_logo.gif");
        mailinfo.setImagePath(imagesMap);
        return mailinfo;

    }
    @RequestMapping( value="/getMailpart" )
    @ResponseBody
    public void Mailpart(@RequestParam(name = "domainId") String domainId){
        MailContentConfigimpl mailcontentconfig = new MailContentConfigimpl();
        mailcontentconfig.getMailContentConfigbyUserID(domainId);
    }

    @RequestMapping(value = "/save/mailSender")
    @ResponseBody
    public JsonResult MailSender() {
        // 发送邮件
        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        return sms.sendHtmlMail(userVo);
    }

}
