package com.hundsun.login.dataobject;

public class WeeklyinfoDOKey {

    private String domainId;


    private String transDate;
    private String rpStatus;

    public String getRpStatus() {
        return rpStatus;
    }

    public void setRpStatus(String rpStatus) {
        this.rpStatus = rpStatus;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

}