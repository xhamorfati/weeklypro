package com.hundsun.showinfomation.controller;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.modelset.bean.JsonResult;
import com.hundsun.showinfomation.bean.InformationDo;
import com.hundsun.showinfomation.bean.ShowConfig;
import com.hundsun.showinfomation.bean.UserInfo;
import com.hundsun.showinfomation.service.InformationSetService;
import com.hundsun.showinfomation.service.ShowInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller

public class ShowInfomationController {
    @Autowired
    private ShowInfomationService showInfomationService=new ShowInfomationService();
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private InformationSetService informationset;

    //跳转到showinfomation界面
    @RequestMapping( value="/showinfomation")
    public String  getinfo() {
        return "showinfomation";
    }

    //获取当前用户信息以展示
    @RequestMapping( value="/getshowinfomation" ,method = {RequestMethod.GET})
    @ResponseBody
    //public UserInfo getUserInfo(@RequestParam(name="name", required = false)String name, @RequestParam(name="workid", required = false)String workid) {
    public UserInfo getUserInfo() {
       // httpServletRequest.getSession().getAttribute('')
        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        UserInfo usi=showInfomationService.getmation(userVo.getDomainId());
        return usi;
    }
    //用于获取界面配置项
    @RequestMapping( value="/selectconfig" ,method = {RequestMethod.GET})
    @ResponseBody
    ShowConfig selectconfig(@RequestParam(name="name",required = false) String name){
       // ShowConfig sc=showInfomationService.selectconfig(name);
        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        ShowConfig sc=showInfomationService.selectconfig(userVo.getDomainId());
        System.out.println(sc.getProblemdisplay());
        return sc;
    }
    //获取buginfo
    @RequestMapping( value="/getbuginfo" ,method = {RequestMethod.GET})
    @ResponseBody
    String getbuginfo(@RequestParam(name="daterange",required = false) String daterange){
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<String, String>();
        if(daterange==""){
           json="数据错误，不处理";
        }else {
            String range = daterange.replaceAll("-", "");//含有全角空格，需要再次处理下
            String finalrange = range.replaceAll("  ", "").trim();

            String begindate = finalrange.substring(0, 7);
            String enddate = finalrange.substring(8, 15);

            map.put("缺陷数量", "20");
            map.put("缺陷等级", "严重");
            map.put("缺陷发现效率", "1.7");
            try {
                json = mapper.writeValueAsString(map);
            } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(json);
        }
        return json;
    }

    //获取ts数据
    @RequestMapping( value="/gettsinfo" ,method = {RequestMethod.GET})
    @ResponseBody
    String gettsinfo(@RequestParam(name="daterange",required = false) String daterange){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> tsmap = new HashMap<String, String>();
        String jsonsss = "";
      if(daterange==""){
                jsonsss="错误";
      }else {
          String tsrange = daterange.replaceAll("-", "");//含有全角空格，需要再次处理下
          String finalrange = tsrange.replaceAll("  ", "").trim();

          String tsbegindate = finalrange.substring(0, 7);
          String tsenddate = finalrange.substring(8, 15);


          tsmap.put("修改单数量", "0");
          tsmap.put("待测试修改单", "0");
          tsmap.put("测试完成修改单", "0");
          try {
              jsonsss = mapper.writeValueAsString(tsmap);
          } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
              e.printStackTrace();
          }
      }
        return jsonsss;
    }

    @RequestMapping(value = "/save/information")
    @ResponseBody
    public JsonResult weeklysave(InformationDo informationdo){
        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        return  informationset.saveContent(userVo,informationdo);
}

//    @RequestMapping(value = "/modify/information")
//    @ResponseBody
//    public JsonResult weeklymodify(@PathVariable("informationdo")InformationDo informationdo){
//        UserVo userVo = (UserVo) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
//        return   informationset.modifyContent(userVo.getDomainId(),informationdo); }
//

}
