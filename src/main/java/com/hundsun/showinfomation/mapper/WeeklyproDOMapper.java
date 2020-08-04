package com.hundsun.showinfomation.mapper;
import com.hundsun.login.controller.viewobject.UserVo;
import com.hundsun.mailSender.dataobject.WeeklyContentDo;
import com.hundsun.showinfomation.bean.InformationDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface WeeklyproDOMapper {
    /**
     * 插入一条周报记录
     * @param informationdo
     * @return
     */

    @Insert("INSERT INTO tbweeklyinfo (weeklypro_id,user_id,rp_status,start_date,fin_date,sys_date,question_range,risk_range,special_item,autotest_msg,other_msg,teacher_name,nextweek_special_item,nextweek_autotest_msg,nextweek_other_msg) VALUES(0,#{user_id},1,#{start_date},#{fin_date},#{sys_date},0,0,0,0,#{informationdo.weeksuminfo},0,0,0,#{informationdo.nextweekinfo})")
    void saveContent(@Param("user_id") String user_id,@Param("start_date") String start_date,@Param("fin_date") String fin_date,@Param("sys_date") String sys_date,InformationDo informationdo);

    @Insert("INSERT INTO tbquestionandrisk (id,name,jobnumber,senddate,type,typename,infoid,info,method,domain_id) VALUES(0,#{userVo.name},#{userVo.workId},#{sys_date},1,1,1,#{informationdo.quesioninfo},#{informationdo.questionmethod},#{userVo.domainId})")
    @Options(useGeneratedKeys = true, keyProperty = "question_range", keyColumn = "id")
    void saveQuesContent(@Param("informationdo") InformationDo informationdo,@Param("sys_date") String sys_date,@Param("userVo") UserVo userVo);

    @Insert("INSERT INTO tbquestionandrisk (id,name,jobnumber,senddate,type,typename,infoid,info,method,domain_id) VALUES(0,#{userVo.name},#{userVo.workId},#{sys_date},2,1,1,#{informationdo.riskinfo},#{informationdo.riskmethod},#{userVo.domainId})")
    @Options(useGeneratedKeys = true, keyProperty = "risk_range", keyColumn = "id")
    void saveRiskContent(@Param("informationdo") InformationDo informationdo,@Param("sys_date") String sys_date,@Param("userVo") UserVo userVo);
    /**
     * 修改一条周报记录
     * @param user_id,sys_date,informationdo
     * @return
     */
    @Update("update tbweeklyinfo set start_date=#{informationdo.start_date},fin_date=#{informationdo.fin_date},sys_date=#{informationdo.sys_date},question_range=#{informationdo.question_range},risk_range=#{informationdo.risk_range} ,special_item=#{informationdo.special_item},autotest_msg=#{informationdo.autotest_msg},other_msg=#{informationdo.other_msg},teacher_name=#{informationdo.teacher_name},nextweek_special_item=#{informationdo.nextweek_special_item},nextweek_autotest_msg=#{informationdo.nextweek_autotest_msg},nextweek_other_msg=#{informationdo.nextweek_other_msg} where user_id= #{user_id} and sys_date = #{informationdo.getSys_date()}")
    void modifyContent(@Param("user_id") String user_id,@Param("informationdo") InformationDo informationdo);

    /**
     * 获取对应id的周报的状态
     * @param sys_date,user_id
     * @return
     */
    @Select(value = "select rp_status from tbweeklyinfo u where user_id =#{user_id} and sys_date =#{sys_date}")
    @Results({@Result(property = "rp_status",column = "rp_status")})
    String getStatus(@Param("user_id") String user_id,@Param("sys_date") String sys_date);
    /**
     * 获取对应id的周报的状态
     * @param sys_date,user_id
     * @return
     */
    @Select(value = "select * from tbweeklyinfo u where user_id =#{user_id} and sys_date =#{sys_date}")
    WeeklyContentDo getTbweeklyinfo(@Param("user_id") String user_id, @Param("sys_date") String sys_date);


}
