package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Process;
import org.apache.ibatis.annotations.*;

public interface ProcessMapper {
    @Delete({
        "delete from process",
        "where process_id = #{processId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String processId);

    @Insert({
        "insert into process (process_id, technology_plan_id, ",
        "sequence, quota)",
        "values (#{processId,jdbcType=VARCHAR}, #{technologyPlanId,jdbcType=VARCHAR}, ",
        "#{sequence,jdbcType=INTEGER}, #{quota,jdbcType=INTEGER})"
    })
    int insert(Process record);

    int insertSelective(Process record);

    @Select({
        "select",
        "process_id, technology_plan_id, sequence, quota",
        "from process",
        "where process_id = #{processId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProcessMapper.BaseResultMap")
    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    @Update({
        "update process",
        "set technology_plan_id = #{technologyPlanId,jdbcType=VARCHAR},",
          "sequence = #{sequence,jdbcType=INTEGER},",
          "quota = #{quota,jdbcType=INTEGER}",
        "where process_id = #{processId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Process record);
}