package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Technology;
import org.apache.ibatis.annotations.*;

public interface TechnologyMapper {
    @Delete({
        "delete from technology",
        "where technology_id = #{technologyId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String technologyId);

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
    int insert(Technology record);

    int insertSelective(Technology record);

    @Select({
        "select",
        "technology_id, technology_name, price, vital_process_period, standard_capacity, ",
        "overtime_standard_capacity, overtime_overfulfil_capacity, double_capacity, overfulfil_capacity",
        "from technology",
        "where technology_id = #{technologyId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyMapper.BaseResultMap")
    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

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
}