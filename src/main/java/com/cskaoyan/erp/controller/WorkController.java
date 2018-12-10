package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Product;
import com.cskaoyan.erp.bean.Work;
import com.cskaoyan.erp.service.ProductService;
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
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    ProductService productService;

   /* @Autowired
    ProcessService processService;

    @Autowired
    DeviceService deviceService;*/

    //查找作业
    @RequestMapping("/find")
    public String find(){
        return "/work_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Work> list(PageModel pageModel) {
        Work work = new Work();
        List<Work> works = workService.selectWork(work,pageModel);
        return works;
    }

    @RequestMapping("/search_work_by_workId")
    @ResponseBody
    public List<Work> search_work_by_workId(String searchValue,PageModel pageModel){
        Work work  = new Work();
        work.setWorkId(searchValue);
        List<Work> works = workService.selectWork(work, pageModel);
        return works;
    }
    @RequestMapping("/search_work_by_workProduct")
    @ResponseBody
    public List<Work> search_work_by_workProduct(String searchValue,PageModel pageModel){
        Product productByName = productService.findProductByName(searchValue);
        Work work  = new Work();
        work.setWorkProduct(productByName);
        List<Work> works = workService.selectWork(work, pageModel);
        return works;
    }
    /*@RequestMapping("/search_work_by_workDevice")
    @ResponseBody
    public List<Work> search_work_by_workDevice(String searchValue,PageModel pageModel){
        DeviceService deviceByName = deviceService.findDeviceByName(searchValue);
        Work work  = new Work();
        work.setWorkDevice(deviceByName);
        List<Work> works = workService.selectWork(work, pageModel);
        return works;
    }
    @RequestMapping("/search_work_by_workProcess")
    @ResponseBody
    public List<Work> search_work_by_workProcess(String searchValue,PageModel pageModel){
        ProcessService processByName = deviceService.findProcessByName(searchValue);
        Work work  = new Work();
        work.setWorkProcess(processByName);
        List<Work> works = workService.selectWork(work, pageModel);
        return works;
    }*/

    //增加作业
    @RequestMapping("/add_judge")
    @ResponseBody
    public void add_judge(){}

    @RequestMapping("/add")
    public String add(){
        return "work_add";
    }

    @RequestMapping("/insert")
    public String insert(@RequestBody @Valid Work work, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "work_add";
        }else {
            boolean b = workService.insertWork(work);
            if(b){
                return "work_list";
            }else {
                return "work_add";
            }
        }
    }

    //修改作业
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void edit_judge(){}

    @RequestMapping("/edit")
    public String edit(){
        return "work_edit";
    }

    @RequestMapping("/update_all")
    public String update_all(@RequestBody Work work ,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "work_edit";
        }else {
            boolean b = workService.updateWork(work);
            if(b){
                return "work_list";
            }else {
                return "work_edit";
            }
        }
    }

    //删除作业
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete_judge(){}

    @RequestMapping("/delete_batch")
    public String delete_batch(@RequestBody @RequestParam("ids")String ids_str){
        String[] ids = ids_str.split(",");
        boolean b = workService.deleteWork(ids);
        if(b){
            return "work_list";
        }else {
            return "work_list";
        }
    }
}
