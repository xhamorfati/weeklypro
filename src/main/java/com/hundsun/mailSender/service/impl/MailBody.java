package com.hundsun.mailSender.service.impl;
import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.mailSender.dataobject.*;
import com.hundsun.mailSender.mapper.MailSenderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MailBody {
    @Autowired
    private MailSenderMapper mailmapper;


    public  MimeMultipart mailText(String sys_date, UserVo userVo, MailSenderInfoDO mailinfo, MailSenderModelDO mailmodel, MailConfigInfoDO mailconfig, WeeklyContentDo weekDo,List<String> qinfo,List<String> qinfomethod,List<String> rinfols,List<String> rinfomethod) throws MessagingException, UnsupportedEncodingException {
            String[] filelist = mailmodel.getAttachaddr().split(",");
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart text = new MimeBodyPart();
            StringBuilder content = new StringBuilder();
            Map<String, String> imagesMap = new HashMap<>();
            String[] Tsconfig = mailconfig.getTsdisplayfields().split(",");
            String[] Qcconfig = mailconfig.getBugdisplayfields().split(",");
            String[] planconfig = mailconfig.getSumlplan().split("：");

            List<String> Qcconfiglist = new ArrayList<String>(){{
                add("有效缺陷");
                add("严重缺陷");
                add("一般缺陷");
                add("其他");
                add("自动化缺陷");
                add("案例评审缺陷");
                add("设计评审缺陷");
                add("自动化测试");
                add("自动化测试占比");
                add("已反馈任务用例");
                add("未反馈任务用例");
            }};
            List<String> Tsconfiglist = new ArrayList<String>(){{
                add("测试未完成修改单情况");
                add("未测修改单");
                add("周期>1.5天");
                add("后台修改");
                add("后台修改单占比");
                add("后台自动化测试");
                add("后台自动化占比");
                add("自动化测试");
                add("自动化测试占比");
                add("已反馈任务用例");
                add("未反馈任务用例");
            }};
            content.append("<span style=\"font-weight:bold;\">您好，以下为本周工作总结，请阅:</span><br><br>");
            //问题模块
            if(mailconfig.getProblemdisplay().equals("on")) {
                    int i =0;
                    content.append("问题描述：");
                    content.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"2\" bgcolor=\"#F0F8FF\" bordercolor=\"#000000\" style=\"font-family:'微软雅黑',Helvetica,Arial,sans-serif;font-size:14px \">"
                        + "<tr><td width=\"10%\">日期</td><td style=\"color:#f00\" width=\"10%\">问题序号</td><td width=\"35%\">问题描述</td>"
                        + "<td width=\"10%\">提出人</td>"
                        + "<td width=\"35%\">解决方法</td></tr>");
                Iterator<String> iter = qinfo.iterator();
                while (iter.hasNext()) {
                    content.append("<tr><td width=\"10%\" height=\"20px\">" + sys_date + "</td>" +
                                    "<td style=\"color:#f00\" width=\"10%\">" + i + "</td>"
                                    + "<td width=\"35%\">" + qinfo.get(i) + "</td>");
                    content.append("<td width=\"10%\">" + userVo.getName() + "</td>"
                                    + "<td width=\"35%\">"+qinfomethod.get(i)+"</td>");
                    content.append("</tr></table>");
                    i = i + 1;
                }
            }
            //风险模块
            if(mailconfig.getRiskdisplay().equals("on")){
                int a=1;
                content.append("风险描述：");
                content.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"2\" bgcolor=\"#F0F8FF\" bordercolor=\"#000000\" style=\"font-family:'微软雅黑',Helvetica,Arial,sans-serif;font-size:14px \">"
                        + "<tr><td width=\"10%\">日期</td><td style=\"color:#f00\" width=\"10%\">风险序号</td><td width=\"35%\">问题描述</td>"
                        + "<td width=\"10%\">提出人</td>"
                        + "<td width=\"35%\">解决方法</td></tr>");
                Iterator<String> iter = rinfols.iterator();
                while (iter.hasNext()) {
                    content.append("<tr><td width=\"10%\" height=\"20px\">" + sys_date + "</td>" +
                            "<td style=\"color:#f00\" width=\"10%\">" + (a+1) + "</td>"
                            + "<td width=\"35%\">" + rinfols.get(a) + "</td>");
                    content.append("<td width=\"10%\">" + userVo.getName() + "</td>"
                            + "<td width=\"35%\">"+rinfomethod.get(a)+"</td>");
                    content.append("</tr></table>");
                    a = a + 1;
                }
            }

            //修改单模块
            if(mailconfig.getTsdisplay().equals("on")) {
                content.append("<br><font >修改单情况:</font><font color =\"#C0C0C0\">自动统计7天内（不含当日）的数据</font><br>");
                content.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"2\" bgcolor=\"#F0F8FF\" bordercolor=\"#000000\" style=\"font-family:'微软雅黑',Helvetica,Arial,sans-serif;font-size:14px \">"
                        + "<tr>");
                for (String config : Tsconfiglist) {
                    content.append("<td width=\"9%\" >" + config + "</td>");
                }
                content.append("</tr>");
                for (String config : Tsconfiglist) {
                    content.append("<td width=\"9%\" height=\"20px\">" + "" + "</td>");
                }
                content.append("</tr></table>");
            }
            //缺陷情况
            if(mailconfig.getBugdisplay().equals("on")) {
                content.append("<br><font >缺陷情况:</font><font color =\"#C0C0C0\">自动统计7天内（不含当日）的数据</font><br>");
                content.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"2\" bgcolor=\"#F0F8FF\" bordercolor=\"#000000\" style=\"font-family:'微软雅黑',Helvetica,Arial,sans-serif;font-size:14px \"><tr>");
                for (String qcconfig : Qcconfiglist) {
                    content.append("<td width=\"9%\">" + qcconfig + "</td>");
                }
                content.append("</tr>");
                for (String config : Qcconfig) {
                    content.append("<td width=\"9%\" height=\"20px\">" + "</td>");
                }
                content.append("</tr></table>");
            }
                //总结与计划
            if(mailconfig.getSumlplandisplay().equals("on")) {
                content.append("<br><font >总结与计划:</font>");
                content.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"2\" bgcolor=\"#F0F8FF\" bordercolor=\"#000000\" style=\"font-family:'微软雅黑',Helvetica,Arial,sans-serif;font-size:14px \"> ");
                content.append("<tr><td width=\"40%\" >本周总结</td><td width=\"40%\" >下周计划</td></tr>");
                content.append("<tr><td width=\"40%\" >");
                for (String config : planconfig) {
                    content.append("<font>" + config + "</font><br>");
                }
                content.append("<tr><td width=\"40%\" >");
                for (String config : planconfig) {
                    content.append("<font>" + config + "</font><br>");
                }
                content.append("</tr></table>");
            }
            //签名部分
            content.append("<br><br><hr /><br>");
            content.append("<font size=\"5\" style=\"font-weight:bold;\">"+ userVo.getName()+"</font><br>");
            content.append("<span><font>恒生电子股份有限公司</font><br><font>"+userVo.getReserve2()+userVo.getReserve3()+"</font><br><font>杭州市滨江区江南大道3588号恒生大厦</font><br></span>");
            content.append("<font>Email:"+userVo.getName()+"</font><br>");
            content.append("<p><video poster=\"java/person_logo.gif\"></p>");

            mailinfo.setContent(content.toString());
            text.setContent(content.toString(), "text/html;charset=UTF-8");

            multipart.addBodyPart(text);

            //设置图片
            if (imagesMap != null && !imagesMap.isEmpty()) {
                for (Map.Entry<String, String> entry: imagesMap.entrySet()) {
                    /* 创建一个表示图片的MimeBodyPart对象，并将它加入到前面的创建的MimeMultipart对象中 */
                    MimeBodyPart pictureBodyPart = new MimeBodyPart();
                    // FileDataSource用于读取文件数据，并返回代表数据的输入输出流和数据的MIME类型
                    FileDataSource fileDataSource = new FileDataSource(entry.getValue());
                    // DataHandler类用于封装FileDataSource对象，并为应用程序提供访问数据的接口
                    pictureBodyPart.setDataHandler(new DataHandler(fileDataSource));
                    pictureBodyPart.setContentID(entry.getKey());
                    multipart.addBodyPart(pictureBodyPart);
            }
        }
            //设置附件内容
//            if (filelist != null && filelist.length > 0) {
//                for (String path : filelist) {
//                    MimeBodyPart bodyPart = new MimeBodyPart();
//                    DataSource dh = new FileDataSource(path);
//                    bodyPart.setDataHandler(new DataHandler(dh));
//                    // 解决中文附件乱码
//                    bodyPart.setFileName(MimeUtility.encodeText(dh.getName()));
//                    multipart.addBodyPart(bodyPart);
//                }
//            }
            return multipart;

        }



}
