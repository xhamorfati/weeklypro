package com.hundsun.showinfomation.service;

import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.modelset.bean.JsonResult;
import com.hundsun.showinfomation.bean.InformationDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import  com.hundsun.showinfomation.mapper.WeeklyproDOMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class InformationSetService {

    @Autowired
    private  WeeklyproDOMapper weeklyproDOMapper;

    public JsonResult saveContent(UserVo userVo, InformationDo informationdo) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String sys_date = df.format(new Date());
        String user_id =userVo.getDomainId();

        if (informationdo == null) {
            System.out.print("1");
            return JsonResult.fail("保存内容为空");
        }
        if(weeklyproDOMapper.getTbweeklyinfo(user_id,sys_date).getWeeklypro_id().length()<=0){
        //if (!weeklyproDOMapper.getStatus(user_id,sys_date).equals("1")) {
            try {
                String tsrange = informationdo.getRange_date().replaceAll("-", "");
                String range = tsrange.replaceAll("  ", "").trim();//含有全角空格，需要再次处理下
                String start_date =range.substring(0, 8);
                String fin_date =range.substring(8, 16);
                weeklyproDOMapper.saveQuesContent(informationdo,sys_date,userVo);
                weeklyproDOMapper.saveRiskContent(informationdo,sys_date,userVo);
                weeklyproDOMapper.saveContent(userVo.getDomainId(),start_date,fin_date,sys_date,informationdo);
            } catch (Exception e) {
                e.printStackTrace();
                return JsonResult.fail(e.getMessage());
            }
            return JsonResult.ok("周报保存成功");
        }
        else if (weeklyproDOMapper.getTbweeklyinfo(user_id,sys_date).getRp_status().equals("1")){
            return JsonResult.ok("今日已有周报发送,请勿重复发送");
        }
        else{
            return JsonResult.fail("今日已有周报保存,请勿重复新增");
        }
    }


//    public JsonResult modifyContent(String user_id, InformationDo informationdo ) {
//        String status = weeklyproDOMapper.getStatus(user_id,informationdo.getSys_date());
//        if(user_id == null){
//            return JsonResult.fail("传入周报查询条件为空，检查是否登录或系统日期是否正常");
//        }
//        if(status.equals("2")){
//            return JsonResult.fail("不存在草稿状态的周报信息，无法修改");
//        }
//        try {
//            weeklyproDOMapper.modifyContent(user_id,informationdo);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return JsonResult.fail(e.getMessage());
//        }
//        return JsonResult.ok();
//
//    }
}
