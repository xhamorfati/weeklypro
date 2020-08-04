package com.hundsun.mailSender.dataobject;

public class MailConfigInfoDO {

    private  String user_id;
    //问题表格是否展示
    private String problemdisplay;
    //风险表格是否展示
    private String riskdisplay;
    // qc表格是否展示
    private String bugdisplay;
    // ts表格是否展示
    private String tsdisplay;
    // 周计划是否展示
    private String sumlplandisplay;
    //ts表格展示项
    private String tsdisplayfields;
    // qc表格展示项目
    private String bugdisplayfields;
    // 周计划展示项
    private String sumlplan;



    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRiskdisplay() {
        return riskdisplay;
    }

    public void setRiskdisplay(String riskdisplay) {
        this.riskdisplay = riskdisplay;
    }

    public String getBugdisplay() {
        return bugdisplay;
    }

    public void setBugdisplay(String bugdisplay) {
        this.bugdisplay = bugdisplay;
    }

    public String getTsdisplay() {
        return tsdisplay;
    }

    public void setTsdisplay(String tsdisplay) {
        this.tsdisplay = tsdisplay;
    }

    public String getSumlplandisplay() {
        return sumlplandisplay;
    }

    public void setSumlplandisplay(String sumlplandisplay) {
        this.sumlplandisplay = sumlplandisplay;
    }

    public String getTsdisplayfields() {
        return tsdisplayfields;
    }

    public void setTsdisplayfields(String tsdisplayfields) {
        this.tsdisplayfields = tsdisplayfields;
    }

    public String getBugdisplayfields() {
        return bugdisplayfields;
    }

    public void setBugdisplayfields(String bugdisplayfields) {
        this.bugdisplayfields = bugdisplayfields;
    }

    public String getSumlplan() {
        return sumlplan;
    }

    public void setSumlplan(String sumlplan) {
        this.sumlplan = sumlplan;
    }

    public String getProblemdisplay() {
        return problemdisplay;
    }

    public void setProblemdisplay(String problemdisplay) {
        this.problemdisplay = problemdisplay;
    }
}