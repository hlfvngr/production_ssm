package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface TaskMapper {
    @Delete({
        "delete from task",
        "where task_id = #{taskId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String taskId);


    int insert(Task task);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKey(Task record);

    int count(Map<String, Object> map);

    List<Task> selectByPage(Map<String, Object> map);
}