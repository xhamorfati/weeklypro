package com.hundsun.login.dataobject;

import java.math.BigDecimal;

public class WeeklyinfoHomePageDO {
    private Integer transDate;
    private Integer rpStatus;

    public Integer getRpStatus() {
        return rpStatus;
    }

    public Integer getTransDate() {
        return transDate;
    }

    public void setRpStatus(Integer rpStatus) {
        this.rpStatus = rpStatus;
    }

    public void setTransDate(Integer transDate) {
        this.transDate = transDate;
    }
}