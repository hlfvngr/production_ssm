package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Task;
import com.cskaoyan.erp.utils.page.PageModel;

import java.util.List;

public interface TaskService {

    List<Task> findAllTask(Task task, PageModel pageModel);

    boolean insertTask(Task task);

    boolean updateTask(Task task);

    boolean deleteTask(String[] ids);

}
