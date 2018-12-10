package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Task;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

public interface TaskMapper {

    int insertSelective(Task record);


    int updateByPrimaryKeySelective(Task record);


    int insert(Task task);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKey(Task record);

    int count(Map<String, Object> map);

    List<Task> selectByPage(Map<String, Object> map);
}