package com.hundsun.mailSender.service.impl;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;

import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.mailSender.dataobject.*;
import com.hundsun.mailSender.mapper.MailSenderMapper;
import com.hundsun.modelset.bean.JsonResult;
import com.hundsun.showinfomation.bean.InformationDo;
import com.hundsun.showinfomation.mapper.WeeklyproDOMapper;
import com.hundsun.showinfomation.service.InformationSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class SimpleMailSender {
    @Autowired
    private MailSenderMapper mailmapper;
    @Autowired
    private WeeklyproDOMapper weeklyproDOMapper;
    @Autowired
    private InformationSetService informationSetService;

//public JsonResult sendHtmlMail(UserVo userVo, InformationDo informationdo) {
public JsonResult sendHtmlMail(UserVo userVo) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String sys_date = df.format(new Date());
        String user_id =userVo.getDomainId();
        //判断列表中是否存在记录，若存在记录则调用modify更改记录，若不存在记录调用save保存；然后发送邮件
        if (weeklyproDOMapper.getTbweeklyinfo(user_id, sys_date)== null) {
            //informationSetService.saveContent(userVo,informationdo);
        } else {
        }
        try {
            MailSenderModelDO mailmodel = mailmapper.findMailSetting(user_id);
            MailConfigInfoDO mailconfig = mailmapper.findMailConfig(user_id);
            WeeklyContentDo weekDo = mailmapper.findMailContent(user_id, sys_date);
            String[] wknum=weekDo.getQuestion_range().split(",");
            ArrayList<String> qinfols = new ArrayList();
            ArrayList<String> qinfomethod = new ArrayList();
            String[] rsnum=weekDo.getRisk_range().split(",");
            ArrayList<String> rinfols = new ArrayList();
            ArrayList<String> rinfomethod = new ArrayList();

            if(wknum.length>0) {
                for (String num:wknum) {
                    QuesandRiskDo qsdo = mailmapper.getQuesandRisk(num);
                    qinfols.add(qsdo.getInfo());
                    qinfomethod.add(qsdo.getMethod());
                }
            }
            if(rsnum.length>0) {
                for (String num:rsnum) {
                    QuesandRiskDo qsdo = mailmapper.getQuesandRisk(num);
                    rinfols.add(qsdo.getInfo());
                    rinfomethod.add(qsdo.getMethod());
                }
            }
            MailSenderInfoDO mailinfo = new MailSenderInfoDO();
            Properties props = new Properties();
            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", mailinfo.getMailServerHost());
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");
            //设置端口
            props.setProperty("mail.smtp.port", mailinfo.getMailServerPort());
            Session session = Session.getInstance(props);
            Message msg = new MimeMessage(session);
            msg.setSubject(mailmodel.getTopical());

            String to = mailmodel.getReciplent();
            String cc = mailmodel.getCopyto();

            // 多个收件人地址
            InternetAddress[] addressesTo = null;
            if (to != null && to.trim().length() > 0) {
                String[] receiveList = to.split(",");
                int receiveCount = receiveList.length;
                if (receiveCount > 0) {
                    addressesTo = new InternetAddress[receiveCount];
                    for (int i = 0; i < receiveCount; i++) {
                        addressesTo[i] = new InternetAddress(receiveList[i]);
                    }
                }
            } else {
                return JsonResult.fail("请设置收件人");
            }

            // 多个抄送人地址
            InternetAddress[] addressesCc = null;
            if (cc != null && cc.length() > 0) {
                String[] copyList = cc.split(",");
                int copyCount = copyList.length;
                if (copyCount > 0) {
                    addressesCc = new InternetAddress[copyCount];
                    for (int i = 0; i < copyCount; i++) {
                        addressesCc[i] = new InternetAddress(copyList[i]);
                    }
                }
            }
            mailinfo.setFromAddress("xuhao25219@hundsun.com");
            MailBody mailbody = new MailBody();
            msg.setFrom(new InternetAddress(mailinfo.getFromAddress(), userVo.getName()));
            msg.setRecipients(MimeMessage.RecipientType.TO, addressesTo);
            msg.setRecipients(MimeMessage.RecipientType.CC, addressesCc);
            System.out.print("邮件发送步骤1");
            msg.setContent(mailbody.mailText(sys_date,userVo, mailinfo, mailmodel, mailconfig, weekDo,qinfols,qinfomethod,rinfols,rinfomethod));
            Transport transport = session.getTransport();
            System.out.print("邮件发送步骤2");

            transport.connect(mailinfo.getMailServerHost(), mailmodel.getUser_id(), "Xh123456");
            transport.sendMessage(msg, new Address[]{new InternetAddress(mailmodel.getReciplent())});
            transport.close();
            return JsonResult.ok("邮件发送成功");
        } catch (Exception e) {
            return JsonResult.fail(e.toString());
        }
    }
}

