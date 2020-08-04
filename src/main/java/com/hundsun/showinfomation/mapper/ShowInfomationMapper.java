
package com.hundsun.showinfomation.mapper;

import com.hundsun.showinfomation.bean.ShowConfig;
import com.hundsun.showinfomation.bean.Showinfomation;
import com.hundsun.showinfomation.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface ShowInfomationMapper {


    /**
     *
     * 查找部门信息，用于显示在周报页面上
     */
    @Select(value = "select u.name,u.work_id,u.reserve2,u.reserve3 from tb_user_info u where u.domain_id=#{domainid}")
    UserInfo getUserInfo(@Param("domainid") String domainid);

    @Select(value = "select u.problemdisplay,u.riskdisplay,u.bugdisplay,u.tsdisplay from tbmodelsetinfo u where u.user_id = #{name}")
    ShowConfig selectconfig(@Param("name") String name);
}
