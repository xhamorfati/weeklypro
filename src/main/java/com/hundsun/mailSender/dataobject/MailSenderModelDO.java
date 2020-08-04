package com.hundsun.mailSender.dataobject;

public class MailSenderModelDO {
    private  String user_id;
    private  String reciplent;
    private  String copyto;
    private  String topical;
    private  String attachaddr;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReciplent() {
        return reciplent;
    }

    public void setReciplent(String reciplent) {
        this.reciplent = reciplent;
    }

    public String getCopyto() {
        return copyto;
    }

    public void setCopyto(String copyto) {
        this.copyto = copyto;
    }

    public String getTopical() {
        return topical;
    }

    public void setTopical(String topical) {
        this.topical = topical;
    }

    public String getAttachaddr() {
        return attachaddr;
    }

    public void setAttachaddr(String attachaddr) {
        this.attachaddr = attachaddr;
    }
}