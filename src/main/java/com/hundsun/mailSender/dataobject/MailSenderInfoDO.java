package com.hundsun.mailSender.dataobject;

import java.util.Map;
import java.util.Properties;

public class MailSenderInfoDO {

    private  String sys_date;
    // 发送邮件的服务器的IP和端口    
    private String mailServerHost ="smtp.hundsun.cn";
    private String mailServerPort = "25";
    // 是否需要身份验证
    private boolean validate = true;
    // 邮件发送者的地址
    private String fromAddress;
    // 邮件接收者的地址    
    private String toAddress;
    // 登陆邮件发送服务器的用户名和密码    
    private String userName;
    private String password;
    // 邮件主题    
    private String subject;
    // 邮件的文本内容    
    private String content;
    // 邮件附件的文件名    
    private String attachFileNames;


    //邮件抄送人
    private String ccUserAddress;

    private Map<String,String> imagePath;

    /** *//**
     * 获得邮件会话属性
     */
    public Properties getProperties(){
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        return p;
    }


    public String getSys_date() {
        return sys_date;
    }

    public void setSys_date(String sys_date) {
        this.sys_date = sys_date;
    }
    public String getMailServerHost() {
        return mailServerHost;
    }
    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }
    public String getMailServerPort() {
        return mailServerPort;
    }
    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }
    public boolean isValidate() {
        return validate;
    }
    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String attachFileNames) {
        this.attachFileNames = attachFileNames;
    }

    public String getFromAddress() {
        return fromAddress;
    }
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToAddress() {
        return toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String textContent) {
        this.content = textContent;
    }
    public String getCcUserAddress() {
        return ccUserAddress;
    }
    public void setCcUserAddress(String ccUserAddress) {
        this.ccUserAddress = ccUserAddress;
    }
    public Map<String, String> getImagePath() {
        return imagePath;
    }

    public void setImagePath(Map<String, String> imagePath) {
        this.imagePath = imagePath;
    }
}