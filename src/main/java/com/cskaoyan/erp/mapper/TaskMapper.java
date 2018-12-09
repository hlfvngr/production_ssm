package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Task;
import org.apache.ibatis.annotations.*;

public interface TaskMapper {
    @Delete({
        "delete from task",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String taskId);

    @Insert({
        "insert into task (task_id, manufacture_sn, ",
        "work_id, task_quantity, ",
        "working_hours)",
        "values (#{taskId,jdbcType=VARCHAR}, #{manufactureSn,jdbcType=VARCHAR}, ",
        "#{workId,jdbcType=VARCHAR}, #{taskQuantity,jdbcType=INTEGER}, ",
        "#{workingHours,jdbcType=DECIMAL})"
    })
    int insert(Task record);

    int insertSelective(Task record);

    @Select({
        "select",
        "task_id, manufacture_sn, work_id, task_quantity, working_hours",
        "from task",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.TaskMapper.BaseResultMap")
    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    @Update({
        "update task",
        "set manufacture_sn = #{manufactureSn,jdbcType=VARCHAR},",
          "work_id = #{workId,jdbcType=VARCHAR},",
          "task_quantity = #{taskQuantity,jdbcType=INTEGER},",
          "working_hours = #{workingHours,jdbcType=DECIMAL}",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Task record);
}