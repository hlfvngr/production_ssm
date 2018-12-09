package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.bean.TechnologyPlan;
import com.cskaoyan.erp.util.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TechnologyMapper {

    /**工艺管理*/

    /**显示*/
    @Select("select count(*) from technology")
    public Integer technologyCount();

    @Select({"select",
            "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
            "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
            "from technology",
            "limit #{pageModel.firstLimitParam},#{pageModel.rows}"})
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    public List<Technology> selectTechnologyList(@Param("pageModel") PageModel pageModel);



    /**搜索*/
    @Select({
        "select",
        "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
        "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
        "from technology",
        "where technology_id LIKE CONCAT ('%',#{technologyId,jdbcType=VARCHAR},'%')"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    List<Technology> searchByTechnologyId(@Param("technologyId") String technologyId);

    @Select({
            "select",
            "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
            "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
            "from technology",
            "where technology_id LIKE CONCAT ('%',#{technologyId,jdbcType=VARCHAR},'%') ",
            "limit #{pageModel.firstLimitParam} , #{pageModel.rows}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    List<Technology> searchPageByTechnologyId(@Param("technologyId") String technologyId,
                                    @Param("pageModel")PageModel pageModel);


    @Select({
            "select",
            "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
            "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
            "from technology",
            "where technology_name LIKE CONCAT ('%',#{technologyName,jdbcType=VARCHAR},'%')"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    List<Technology> searchByTechnologyName(@Param("technologyName")String technologyName);

    @Select({
            "select",
            "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
            "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
            "from technology",
            "where technology_name LIKE CONCAT ('%',#{technologyName,jdbcType=VARCHAR},'%') ",
            "limit #{pageModel.firstLimitParam} , #{pageModel.rows}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    List<Technology> searchPageByTechnologyName(@Param("technologyName") String technologyName,
                                    @Param("pageModel")PageModel pageModel);


    /**回显*/
    @Select({
            "select",
            "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
            "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
            "from technology"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    List<Technology> findAllTechnology();


    /**新增*/
    @Insert({
            "insert into technology (technology_id, technology_name, ",
            "price, vital_process_period, ",
            "standard_capacity, overtime_standard_capacity, ",
            "overtime_overfulfil_capacity, double_capacity, ",
            "overfulfil_capacity)",
            "values (#{technologyId,jdbcType=VARCHAR}, #{technologyName,jdbcType=VARCHAR}, ",
            "#{price,jdbcType=DECIMAL}, #{vitalProcessPeriod,jdbcType=VARCHAR}, ",
            "#{standardCapacity,jdbcType=INTEGER}, #{overtimeStandardCapacity,jdbcType=INTEGER}, ",
            "#{overtimeOverfulfilCapacity,jdbcType=INTEGER}, #{doubleCapacity,jdbcType=INTEGER}, ",
            "#{overfulfilCapacity,jdbcType=INTEGER})"
    })
    public int insertTechnology(Technology record);


    /**修改*/
    @Update({
            "update technology",
            "set technology_name = #{technologyName,jdbcType=VARCHAR},",
            "price = #{price,jdbcType=DECIMAL},",
            "vital_process_period = #{vitalProcessPeriod,jdbcType=VARCHAR},",
            "standard_capacity = #{standardCapacity,jdbcType=INTEGER},",
            "overtime_standard_capacity = #{overtimeStandardCapacity,jdbcType=INTEGER},",
            "overtime_overfulfil_capacity = #{overtimeOverfulfilCapacity,jdbcType=INTEGER},",
            "double_capacity = #{doubleCapacity,jdbcType=INTEGER},",
            "overfulfil_capacity = #{overfulfilCapacity,jdbcType=INTEGER}",
            "where technology_id = #{technologyId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Technology record);


    /**删除*/
    @Delete({
            "delete from technology",
            "where technology_id = #{technologyId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("technologyId") String technologyId);


    /**开放接口*/
    @Select({
            "select",
            "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
            "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
            "from technology where technology_id = #{technologyId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    Technology selectByPrimaryKey(@Param("technologyId") String technologyId);

}