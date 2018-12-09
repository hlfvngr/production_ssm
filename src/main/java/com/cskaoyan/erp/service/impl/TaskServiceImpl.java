package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Task;
import com.cskaoyan.erp.mapper.TaskMapper;
import com.cskaoyan.erp.service.TaskService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    public List<Task> findAllTask(Task task, PageModel pageModel) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("taskId",task.getTaskId());
        map.put("work",task.getWork());
        map.put("manufacture",task.getManufacture());
        int count = taskMapper.count(map);
        if(count == 0){
            return null;
        }
        pageModel.setRecordCount(count);
        int offset = pageModel.getFirstLimitParam();
        int limit = pageModel.getRows();
        map.put("limit",limit);
        map.put("offset",offset);
        return taskMapper.selectByPage(map);
    }

    public boolean insertTask(Task task) {
        return taskMapper.insert(task) != 0;
    }

    public boolean updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task) != 0;
    }

    public boolean deleteTask(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int ret = taskMapper.deleteByPrimaryKey(ids[i]);
            if(ret == 0){
                return false;
            }
        }
        return true;
    }
}
