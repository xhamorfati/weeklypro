package com.hundsun.modelset.bean;

public class ModelSetBean {

    private Long model_id;
    private String model_name;
    private String user_id;
    private String reciplent;
    private String copyto;
    private String topical;
    private String attachaddr;
    private String problemdisplay = "off";
    private String riskdisplay = "off";
    private String bugdisplay = "off";
    private String tsdisplay = "off";
    private String sumlplandisplay = "off";
    private String tsdisplayfields;
    private String bugdisplayfields;
    private String sumlplan;

    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

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

    public String getProblemdisplay() {
        return problemdisplay;
    }

    public void setProblemdisplay(String problemdisplay) {
        this.problemdisplay = problemdisplay;
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
        /*
        String tempts = ','+tsdisplayfields+',';
        tempts=tempts.replace(",ts_close,",",测试完成,");
        tempts=tempts.replace(",ts_product,",",本周集成,");
        tempts=tempts.replace(",ts_untest,",",未测试,");
        tempts=tempts.replace(",ts_36holder,",",周期大于36h,");
        tempts=tempts.replace(",ts_interface,",",后台修改单,");
        tempts=tempts.replace(",ts_autotest,",",自动化测试,");
        tempts=tempts.replace(",ts_autotestzb,",",自动化占比,");
        tempts=tempts.replace(",ts_interfacetestzb,",",接口自动化占比,");
        tempts=tempts.replace(",ts_bringback,",",测试打回,");
        tempts=tempts.replace(",ts_tasknocase,",",任务未反馈用例,");
        tempts=tempts.replace(",ts_taskhavecase,",",任务已反馈用用例,");

        return  tempts.substring(1,tempts.length()-1);*/
    }

    public void setTsdisplayfields(String tsdisplayfields) {
        this.tsdisplayfields = tsdisplayfields;
        ;
    }

    public String getBugdisplayfields() {
        return bugdisplayfields;
        /*
        String tempbug= ','+bugdisplayfields+',';
        tempbug=tempbug.replace(",bug_amount,",",有效缺陷,");
        tempbug=tempbug.replace(",bug_auto,",",自动化缺陷,");
        tempbug=tempbug.replace(",bug_back,",",后台缺陷,");
        tempbug=tempbug.replace(",bug_designreview,",",评审缺陷,");
        tempbug=tempbug.replace(",bug_casereview,",",用例评审,");
        tempbug=tempbug.replace(",bug_cross,",",交叉测试,");
        tempbug=tempbug.replace(",bug_serousproportions,",",严重缺陷占比,");
        tempbug=tempbug.replace(",bug_fxndzzb,",",发现难度中占比,");
        tempbug=tempbug.replace(",bug_fxndzzb,",",发现难度中占比,");
        tempbug=tempbug.replace(",bug_fixnotclose,",",已修复未关闭,");
        return  tempbug.substring(1,tempbug.length()-1);*/
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

}

