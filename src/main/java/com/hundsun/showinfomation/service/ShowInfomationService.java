package com.hundsun.showinfomation.service;


import com.hundsun.showinfomation.bean.ShowConfig;
import com.hundsun.showinfomation.bean.Showinfomation;
import com.hundsun.showinfomation.bean.UserInfo;
import com.hundsun.showinfomation.mapper.ShowInfomationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ShowInfomationService {
    @Autowired
   private ShowInfomationMapper smapper;
    //存放用户信息方法
    public UserInfo getmation(String domainid){
        return smapper.getUserInfo(domainid);
    }
    //添加信息

   //查找配置表，确定哪些需要显示
   public ShowConfig selectconfig(String name) {

       return smapper.selectconfig(name);
   }

}
