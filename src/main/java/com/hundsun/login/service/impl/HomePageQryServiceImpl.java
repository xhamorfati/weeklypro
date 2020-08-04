package com.hundsun.login.service.impl;

import com.hundsun.login.dataobject.WeeklyinfoDOKey;
import com.hundsun.login.dataobject.WeeklyinfoHomePageDO;
import com.hundsun.login.mapper.WeeklyinfoDOMapper;
import com.hundsun.login.service.HomePageQryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageQryServiceImpl implements HomePageQryService {
    @Autowired
    private WeeklyinfoDOMapper weeklyinfoDOMapper;

    @Override
    public List<WeeklyinfoDOKey> getWeeklyinfoByDomainId(String domainId){
        //调用Mapper获取数据
        List<WeeklyinfoDOKey> wp = weeklyinfoDOMapper.findByDomainId(domainId);
        return wp;
    }
}
