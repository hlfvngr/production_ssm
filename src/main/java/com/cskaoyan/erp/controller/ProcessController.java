package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.TechnologyPlan;
import com.cskaoyan.erp.bean.VO.TechnologyPlanVO;
import com.cskaoyan.erp.service.Impl.ProcessMonitoringServiceImpl;
import com.cskaoyan.erp.service.ProcessMonitoringService;
import com.cskaoyan.erp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cskaoyan.erp.bean.Process;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/7 1:33
 * @需求:
 * @思路说明:
 */
@Controller
public class ProcessController {

    @Autowired
    private ProcessMonitoringService processMonitoringService;


    /**工序管理*/
    @RequestMapping("/process/find")
    public String processFind(){
        return "process_list";
    }

    @ResponseBody
    @RequestMapping("/process/list")
    public Map<String,Object> processList(PageModel pageModel){

        Map<String,Object> map=processMonitoringService.findProcessList(pageModel);

        return map;
    }



    /**搜索*/
    @ResponseBody
    @RequestMapping("/process/search_process_by_processId")
    public Map<String,Object> searchById(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchProcessByProcessId(searchValue,pageModel);
        return map;
    }

    @ResponseBody
    @RequestMapping("/process/search_process_by_technologyPlanId")
    public Map<String,Object> searchByName(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchProcessByPlanId(searchValue,pageModel);
        return map;
    }




    /**回显*/
    @ResponseBody
    @RequestMapping("/technologyPlan/get_data")
    public List<TechnologyPlanVO> getData(){

        List<TechnologyPlanVO> list=processMonitoringService.findAllTechnologyPlan();
        return list;
    }


    /**新增*/
    @ResponseBody
    @RequestMapping("/process/add_judge")
    public String addJudge(){
        return "";
    }

    @RequestMapping("/process/add")
    public String add(){
        return "/process_add";
    }

    @ResponseBody
    @RequestMapping("/process/insert")
    public Map<String,Object> insertProcess(@Valid Process process,
                                                   BindingResult bindingResult){

        Map<String,Object> map=new HashMap<String, Object>();

        if (bindingResult.hasFieldErrors()){  /**校验失败*/

            String msg=null;

            List<FieldError> fieldErrorList=bindingResult.getFieldErrors();

            for (FieldError field:fieldErrorList) {
                msg=field.getDefaultMessage();
            }

            map.put("msg",msg);
            map.put("status",100);

        }else {
            boolean insert=processMonitoringService.insertProcess(process);

            if (insert){
                map.put("msg","OK");
                map.put("status",200);
            }else {
                map.put("msg","fail");
            }

        }

        return map;

    }


    /**修改*/

    @ResponseBody
    @RequestMapping("/process/edit_judge")
    public String editJudge(){
        return "";
    }

    @RequestMapping("/process/edit")
    public String edit(){
        return "/process_edit";
    }

    @ResponseBody
    @RequestMapping("/process/update_all")
    public Map<String,Object> updateAll(@Valid Process process,
                                                   BindingResult bindingResult){

        Map<String,Object> map=new HashMap<String, Object>();

        if (bindingResult.hasFieldErrors()){  /**校验失败*/

            String msg=null;

            List<FieldError> fieldErrorList=bindingResult.getFieldErrors();

            for (FieldError field:fieldErrorList) {
                msg=field.getDefaultMessage();
            }

            map.put("msg",msg);
            map.put("status",100);

        }else {
            boolean insert=processMonitoringService.updateProcess(process);

            if (insert){
                map.put("msg","OK");
                map.put("status",200);
            }else {
                map.put("msg","fail");
            }

        }

        return map;

    }

    /**删除*/
    @ResponseBody
    @RequestMapping("/process/delete_judge")
    public String deleteJudge(){
        return "";
    }

    @ResponseBody
    @RequestMapping("/process/delete_batch")
    public Map<String,Object> deleteBatch(String[] ids){

        Map<String,Object> map=new HashMap<String, Object>();

        boolean delete=processMonitoringService.deleteProcess(ids);

        if (delete){
            map.put("msg","OK");
            map.put("status",200);
        }else {
            map.put("msg","fail");
        }

        return map;
    }

    /**开放接口*/

    @ResponseBody
    @RequestMapping("/process/get/{processId}")
    public Process getTechnology(@PathVariable("processId") String processId){

        Process process=processMonitoringService.getProcessById(processId);

        return process;

    }


}
