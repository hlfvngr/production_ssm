package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Manufacture;
import com.cskaoyan.erp.bean.Task;
import com.cskaoyan.erp.bean.Work;
import com.cskaoyan.erp.service.ManufactureService;
import com.cskaoyan.erp.service.TaskService;
import com.cskaoyan.erp.service.WorkService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    WorkService workService;
    @Autowired
    ManufactureService manufactureService;

    //查找生产派工
    @RequestMapping("/find")
    public String find(){
        return "task_list";
    }

    @RequestMapping("/list")
    public List<Task> list(PageModel pageModel){
        Task task = new Task();
        return taskService.findAllTask(task,pageModel);
    }

    @RequestMapping("/search_task_by_taskId")
    public List<Task> search_task_by_taskId(String searchValue, PageModel pageModel){
        Task task = new Task();
        task.setTaskId(searchValue);
        return taskService.findAllTask(task,pageModel);
    }

    @RequestMapping("/search_task_by_taskWorkId")
    public List<Task> search_task_by_taskWorkId(String searchValue, PageModel pageModel){
        Work work = workService.findWorkById(searchValue);
        Task task = new Task();
        task.setWork(work);
        return taskService.findAllTask(task,pageModel);
    }

    @RequestMapping("/search_task_by_taskManufactureSn")
    public List<Task> search_task_by_taskManufactureSn(String searchValue, PageModel pageModel){
        Manufacture manufacture = manufactureService.findManufactureById(searchValue);
        Task task = new Task();
        task.setManufacture(manufacture);
        return taskService.findAllTask(task,pageModel);
    }

    //增加生产派工
    @RequestMapping("/add_judge")
    @ResponseBody
    public void add_judge(){}

    @RequestMapping("/add")
    public String add(){
        return "task_add";
    }

    @RequestMapping("insert")
    public String insert(@RequestBody @Valid Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "task_add";
        }else {
            boolean b = taskService.insertTask(task);
            if(b){
                return "task_list";
            }else {
                return "task_add";
            }
        }
    }

    //修改生产派工
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void edit_judge(){}

    @RequestMapping("/edit")
    public String edit(){
        return "task_edit";
    }

    @RequestMapping("/update_all")
    public String update_all(@RequestBody @Valid Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "task_edit";
        }else {
            boolean b = taskService.updateTask(task);
            if(b){
                return "task_list";
            }else {
                return "task_edit";
            }
        }
    }

    //删除生产派工

    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete_judge(){}


    @RequestMapping("/delete_batch")
    public String delete_batch(@RequestBody @RequestParam("ids") String ids_str){
        String[] ids = ids_str.split(",");
        boolean b = taskService.deleteTask(ids);
        if(b){
            return "task_list";
        }else {
            return "task_list";
        }
    }
}
