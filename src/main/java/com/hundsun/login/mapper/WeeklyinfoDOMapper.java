package com.hundsun.login.mapper;
import com.hundsun.login.dataobject.WeeklyinfoDOKey;
import com.hundsun.login.dataobject.WeeklyinfoHomePageDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface WeeklyinfoDOMapper {


    @Select(value = "select user_id,rp_status,date_format(sys_date,'%Y%-%c%-%e') trans_date  from tbweeklyinfo u where u.user_id=#{domainId} ")
    @Results
            ({@Result(property = "transDate",column = "trans_date"),
                    @Result(property = "rpStatus",column = "rp_status"),
            @Result(property = "domainId" ,column = "user_id")})
    List<WeeklyinfoDOKey> findByDomainId(@Param("domainId") String domainId);


}
