package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.TechnologyRequirement;
import org.apache.ibatis.annotations.*;

public interface TechnologyRequirementMapper {
    @Delete({
        "delete from technology_requirement",
        "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String technologyRequirementId);

    @Insert({
        "insert into technology_requirement (technology_requirement_id, technology_id, ",
        "requirement, add_time, ",
        "revise_time)",
        "values (#{technologyRequirementId,jdbcType=VARCHAR}, #{technologyId,jdbcType=VARCHAR}, ",
        "#{requirement,jdbcType=VARCHAR}, #{addTime,jdbcType=TIMESTAMP}, ",
        "#{reviseTime,jdbcType=TIMESTAMP})"
    })
    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    @Select({
        "select",
        "technology_requirement_id, technology_id, requirement, add_time, revise_time",
        "from technology_requirement",
        "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyRequirementMapper.BaseResultMap")
    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    @Update({
        "update technology_requirement",
        "set technology_id = #{technologyId,jdbcType=VARCHAR},",
          "requirement = #{requirement,jdbcType=VARCHAR},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "revise_time = #{reviseTime,jdbcType=TIMESTAMP}",
        "where technology_requirement_id = #{technologyRequirementId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TechnologyRequirement record);
}