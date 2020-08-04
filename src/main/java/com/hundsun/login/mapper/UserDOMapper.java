package com.hundsun.login.mapper;

import com.hundsun.login.dataobject.UserDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface UserDOMapper {

    @Select(value = "select t.work_id,t.domain_id,t.name,t.gender,t.email_address,t.reserve1,t.reserve2,t.reserve3 from tb_user_info t where t.domain_id = #{domainId} ")
    @Results ({@Result(property = "workId",column = "work_id"),
            @Result(property = "domainId",column = "domain_id"),
            @Result(property = "emailAddress",column = "email_address")})
    UserDO findByDomainId(@Param("domainId") String domainId);

    @Select(value = "select t.work_id,t.domain_id,t.name,t.gender,t.email_address,t.reserve1,t.reserve2,t.reserve3 from tb_user_info t")
    @Results ({@Result(property = "workId",column = "work_id"),
            @Result(property = "domainId",column = "domain_id"),
            @Result(property = "emailAddress",column = "email_address")})
    List<UserDO> findAll();

    @Select(value = "select t.work_id,t.domain_id,t.name,t.gender,t.email_address,t.reserve1,t.reserve2,t.reserve3 from tb_user_info t where t.work_id like '%${workId}%'")
    @Results ({@Result(property = "workId",column = "work_id"),
            @Result(property = "domainId",column = "domain_id"),
            @Result(property = "emailAddress",column = "email_address")})
    List<UserDO>  findAllByWorkId(@Param("workId") String work_id);


    @Delete("delete from tb_user_info where domain_id = #{domainId} ")
    boolean deleteByDomainId(@Param("domainId") String domainId);

    @Update("update tb_user_info set work_id=#{userDo.workId},name=#{userDo.name},gender=#{userDo.gender},email_address=#{userDo.emailAddress},reserve1=#{userDo.reserve1},reserve2=#{userDo.reserve2},reserve3=#{userDo.reserve3} where domain_id= #{userDo.domainId} ")
    boolean updateByDomainId(@Param("userDo") UserDO userDO);

    @Insert("insert into  tb_user_info (work_id, domain_id, name, gender, email_address, reserve1, reserve2, reserve3) values" +
            "(#{userDO.workId},#{userDO.domainId},#{userDO.name},#{userDO.gender},#{userDO.emailAddress},#{userDO.reserve1},#{userDO.reserve2},#{userDO.reserve3})")
    int insert(@Param("userDO") UserDO userDO);
}
