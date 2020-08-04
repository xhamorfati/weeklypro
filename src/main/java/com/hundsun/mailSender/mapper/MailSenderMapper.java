package com.hundsun.mailSender.mapper;

import com.hundsun.mailSender.dataobject.MailConfigInfoDO;
import com.hundsun.mailSender.dataobject.MailSenderModelDO;
import com.hundsun.mailSender.dataobject.QuesandRiskDo;
import com.hundsun.mailSender.dataobject.WeeklyContentDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface MailSenderMapper {
    /**
     * 插入一条周报记录
     * @param user_id
     * @return
     */
    //邮件内容配置读取
    @Select(value = "select user_id,problemdisplay,riskdisplay,bugdisplay,tsdisplay,sumlplandisplay,tsdisplayfields,bugdisplayfields,sumlplan from tbmodelsetinfo u  where u.user_id =#{user_id}")
    MailConfigInfoDO findMailConfig(@Param("user_id") String user_id);

    //查找是否存在符合要求的周报信息
    @Select(value ="select u.weeklypro_id from tbweeklyinfo u where u.user_id =#{user_id} and u.sys_date =#{sys_date} ")
    @Results
            ({@Result(property = "weelklypro_id",column = "weeklypro_id")})
    String getWeeklyID(@Param("user_id") String user_id,@Param("sys_date") String sys_date);

    //查找问题列表
    @Select(value="select u.senddate,u.infoid,u.info,u.method from tbquestandrisk u where u.id = #{id}")
    QuesandRiskDo getQuesandRisk(@Param("id") String id);



    //邮件发送配置
    @Select(value = "select u.user_id,u.reciplent,u.copyto,u.topical,u.attachaddr from tbmodelsetinfo u where u.user_id =#{user_id} ")
  /*  @Results
            ({@Result(property = "userName",column = "user_id"),
                    @Result(property = "toAddress",column = "reciplent"),
                    @Result(property = "subject",column = "topical"),
                    @Result(property = "attachFileNames",column = "attachaddr"),
                    @Result(property = "ccUserAddress" ,column = "copyto")})*/
    MailSenderModelDO findMailSetting(@Param("user_id") String user_id);

    //邮件内容读取
    @Select(value = "select weeklypro_id,user_id,rp_status,start_date,fin_date,sys_date,question_range,risk_range,special_item,autotest_msg,other_msg,teacher_name,nextweek_special_item,nextweek_autotest_msg,nextweek_other_msg from tbweeklyinfo u where u.user_id =#{user_id} and u.sys_date =#{sys_date}")
  /*  @Results
            ({@Result(property = "weeklypro_id",column = "weeklypro_id"),
                    @Result(property = "user_id",column = "user_id"),
                    @Result(property = "pr_status" ,column = "pr_status"),
                    @Result(property = "start_date",column = "start_date"),
                    @Result(property = "fin_date",column = "fin_date"),
                    @Result(property = "sys_date",column = "sys_date"),
                    @Result(property = "question_range",column = "question_range"),
                    @Result(property = "risk_range",column = "risk_range"),
                    @Result(property = "special_item",column = "special_item"),
                    @Result(property = "autotest_msg",column = "autotest_msg"),
                    @Result(property = "other_msg",column = "other_msg"),
                    @Result(property = "teacher_name",column = "teacher_name"),
                    @Result(property = "risk_range",column = "risk_range"),
                    @Result(property = "nextweek_special_item",column = "nextweek_special_item"),
                    @Result(property = "nextweek_autotest_msg",column = "nextweek_autotest_msg"),
                    @Result(property = "nextweek_other_msg",column = "nextweek_other_msg")
            })*/
    WeeklyContentDo findMailContent(@Param("user_id") String user_id, @Param("sys_date") String sys_date);
}
