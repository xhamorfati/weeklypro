package com.hundsun.login.service;

import com.hundsun.login.dataobject.WeeklyinfoDOKey;
import com.hundsun.login.dataobject.WeeklyinfoHomePageDO;

import java.util.List;

public interface HomePageQryService {
    public List<WeeklyinfoDOKey> getWeeklyinfoByDomainId(String domainId);
}

