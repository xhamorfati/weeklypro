package com.hundsun.modelset.mapper;

import com.hundsun.modelset.bean.ModelSetBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper的具体表达式
 */
@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface ModelSetMapper {

    @Select(value = "select model_id,model_name,user_id,reciplent,copyto,topical,attachaddr,problemdisplay,riskdisplay,bugdisplay,tsdisplay,sumlplandisplay,tsdisplayfields,bugdisplayfields,sumlplan from tbmodelsetinfo where user_id =#{user_id}")
    @Results
            ({@Result(property = "model_id", column = "model_id"),
                    @Result(property = "model_name", column = "model_name"),
                    @Result(property = "user_id", column = "user_id"),
                    @Result(property = "reciplent", column = "reciplent"),
                    @Result(property = "copyto", column = "copyto"),
                    @Result(property = "topical", column = "topical"),
                    @Result(property = "attachaddr", column = "attachaddr"),
                    @Result(property = "problemdisplay", column = "problemdisplay"),
                    @Result(property = "riskdisplay", column = "riskdisplay"),
                    @Result(property = "bugdisplay", column = "bugdisplay"),
                    @Result(property = "tsdisplay", column = "tsdisplay"),
                    @Result(property = "sumlplandisplay", column = "sumlplandisplay"),
                    @Result(property = "tsdisplayfields", column = "tsdisplayfields"),
                    @Result(property = "bugdisplayfields", column = "bugdisplayfields"),
                    @Result(property = "sumlplan", column = "sumlplan")})
    List<ModelSetBean> findModelByUser(String user_id);

    @Select(value = "select model_id,model_name,user_id,reciplent,copyto,topical,attachaddr,problemdisplay,riskdisplay,bugdisplay,tsdisplay,sumlplandisplay,tsdisplayfields,bugdisplayfields,sumlplan from tbmodelsetinfo")
    List<ModelSetBean> findModelByAll();


    @Select(value = "select model_id,model_name,user_id,reciplent,copyto,topical,attachaddr,problemdisplay,riskdisplay,bugdisplay,tsdisplay,sumlplandisplay,tsdisplayfields,bugdisplayfields,sumlplan from tbmodelsetinfo where model_id=#{model_id}")
    /*@Results
            ({@Result(property = "model_id", column = "model_id"),
                    @Result(property = "model_name", column = "model_name"),
                    @Result(property = "user_id", column = "user_id"),
                    @Result(property = "reciplent", column = "reciplent"),
                    @Result(property = "copyto", column = "copyto"),
                    @Result(property = "topical", column = "topical"),
                    @Result(property = "attachaddr", column = "attachaddr"),
                    @Result(property = "problemdisplay", column = "problemdisplay"),
                    @Result(property = "riskdisplay", column = "riskdisplay"),
                    @Result(property = "bugdisplay", column = "bugdisplay"),
                    @Result(property = "tsdisplay", column = "tsdisplay"),
                    @Result(property = "sumlplandisplay", column = "sumlplandisplay"),
                    @Result(property = "tsdisplayfields", column = "tsdisplayfields"),
                    @Result(property = "bugdisplayfields", column = "bugdisplayfields"),
                    @Result(property = "sumlplan", column = "sumlplan")})*/
    ModelSetBean findModelByid(Long model_id);

    /**
     * 注册  插入一条user记录
     *
     * @param modelinfo
     * @return
     */
    @Insert("INSERT INTO tbmodelsetinfo (model_id,model_name,user_id,reciplent,copyto,topical,attachaddr,problemdisplay,riskdisplay,bugdisplay,tsdisplay,sumlplandisplay,tsdisplayfields,bugdisplayfields,sumlplan) VALUES(0,#{model_name},#{user_id},#{reciplent},#{copyto},#{topical},#{attachaddr},#{problemdisplay},#{riskdisplay},#{bugdisplay},#{tsdisplay},#{sumlplandisplay},#{tsdisplayfields},#{bugdisplayfields},#{sumlplan})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true, keyProperty = "model_id", keyColumn = "model_id")
    void insertModel(ModelSetBean modelinfo);


    @Update("update tbmodelsetinfo set model_name = #{model_name},user_id=#{user_id},reciplent=#{reciplent},copyto=#{copyto},topical=#{topical},attachaddr=#{attachaddr},problemdisplay=#{problemdisplay},riskdisplay=#{riskdisplay},bugdisplay=#{bugdisplay},tsdisplay=#{tsdisplay},sumlplandisplay=#{sumlplandisplay},tsdisplayfields=#{tsdisplayfields},bugdisplayfields=#{bugdisplayfields},sumlplan=#{sumlplan} where  model_id=#{model_id}")
    void updateModel(ModelSetBean modelsave);

    @Delete("DELETE from tbmodelsetinfo  where model_id=#{model_id}")

        //加入该注解可以保存对象后，查看对象插入id
    void delModel(Long model_id);
}
