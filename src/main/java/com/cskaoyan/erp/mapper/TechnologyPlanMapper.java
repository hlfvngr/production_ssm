package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.TechnologyPlan;
import org.apache.ibatis.annotations.*;

public interface TechnologyPlanMapper {
    @Delete({
        "delete from technology_plan",
        "where technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String technologyPlanId);

    @Insert({
        "insert into technology_plan (technology_plan_id, technology_id, ",
        "batch_amount, start_plan, ",
        "end_plan, commit_plan, ",
        "technology_plan_start, technology_plan_end)",
        "values (#{technologyPlanId,jdbcType=VARCHAR}, #{technologyId,jdbcType=VARCHAR}, ",
        "#{batchAmount,jdbcType=INTEGER}, #{startPlan,jdbcType=TIMESTAMP}, ",
        "#{endPlan,jdbcType=TIMESTAMP}, #{commitPlan,jdbcType=TIMESTAMP}, ",
        "#{technologyPlanStart,jdbcType=TIMESTAMP}, #{technologyPlanEnd,jdbcType=TIMESTAMP})"
    })
    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    @Select({
        "select",
        "technology_plan_id, technology_id, batch_amount, start_plan, end_plan, commit_plan, ",
        "technology_plan_start, technology_plan_end",
        "from technology_plan",
        "where technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TechnologyPlanMapper.BaseResultMap")
    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    @Update({
        "update technology_plan",
        "set technology_id = #{technologyId,jdbcType=VARCHAR},",
          "batch_amount = #{batchAmount,jdbcType=INTEGER},",
          "start_plan = #{startPlan,jdbcType=TIMESTAMP},",
          "end_plan = #{endPlan,jdbcType=TIMESTAMP},",
          "commit_plan = #{commitPlan,jdbcType=TIMESTAMP},",
          "technology_plan_start = #{technologyPlanStart,jdbcType=TIMESTAMP},",
          "technology_plan_end = #{technologyPlanEnd,jdbcType=TIMESTAMP}",
        "where technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TechnologyPlan record);
}