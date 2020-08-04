package com.hundsun.login.mapper;

import com.hundsun.login.dataobject.UserDO;
import com.hundsun.login.dataobject.UserPasswordDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface UserPasswordDOMapper {
    @Select(value = "select domain_id,encrpt_password from tb_user_password where domain_id = #{domainId} ")
    @Results({
            @Result(property = "domainId",column = "domain_id"),
            @Result(property = "encrptPassword",column = "encrpt_password")})
    UserPasswordDO findByDomainId(@Param("domainId") String domainId);


    @Update("update tb_user_password set encrpt_password=#{userPasswordDO.encrptPassword} where domain_id= #{userPasswordDO.domainId} ")
    boolean updatePassword(@Param("userPasswordDO") UserPasswordDO userPasswordDO);

    @Insert("INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES (#{userPasswordDO.domainId},#{userPasswordDO.encrptPassword})")
    boolean insert(@Param("userPasswordDO") UserPasswordDO userPasswordDO);

    @Delete("delete from tb_user_password where domain_id = #{domainId}")
    boolean deleteByDomainId(@Param("domainId") String domainId);
}
