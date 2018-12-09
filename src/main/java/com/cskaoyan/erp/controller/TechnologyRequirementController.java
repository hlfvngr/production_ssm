package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.bean.TechnologyRequirement;
import com.cskaoyan.erp.bean.VO.TechnologyRequirementVO;
import com.cskaoyan.erp.service.Impl.ProcessMonitoringServiceImpl;
import com.cskaoyan.erp.service.ProcessMonitoringService;
import com.cskaoyan.erp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TechnologyRequirementController {

    /**工艺要求*/

    @Autowired
    private ProcessMonitoringService processMonitoringService;


    /**显示*/
    @RequestMapping("/technologyRequirement/find")
    public String technologyRequirementFind(){
        return "/technologyRequirement_list";
    }

    @ResponseBody
    @RequestMapping("/technologyRequirement/list")
    public Map<String,Object> technologyRequirementList(PageModel pageModel){

        Map<String,Object> map=processMonitoringService.findTechnologyRequirementList(pageModel);

        return map;
    }


    /**搜索*/
    @ResponseBody
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    public Map<String,Object> searchById(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchRequirementByRequirementId(searchValue,pageModel);
        return map;
    }

    @ResponseBody
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyName")
    public Map<String,Object> searchByName(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchRequirementByTechnologyName(searchValue,pageModel);
        return map;
    }



    /**回显*/
    @ResponseBody
    @RequestMapping("/technologyRequirement/get_data")
    public List<Technology> getData(){

        List<Technology> list=processMonitoringService.findAllTechnology();
        return list;
    }


    /**新增*/
    @ResponseBody
    @RequestMapping("/technologyRequirement/add_judge")
    public String addJudge(){
        return "";
    }

    @RequestMapping("/technologyRequirement/add")
    public String add(){
        return "/technologyRequirement_add";
    }

    @ResponseBody
    @RequestMapping("/technologyRequirement/insert")
    public Map<String,Object> insertTechnologyRequirement(@Valid TechnologyRequirement requirement,
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
            boolean insert=processMonitoringService.insertTechnologyRequirement(requirement);

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
    @RequestMapping("/technologyRequirement/edit_judge")
    public String editJudge(){
        return "";
    }

    @RequestMapping("/technologyRequirement/edit")
    public String edit(){
        return "/technologyRequirement_edit";
    }

    @ResponseBody
    @RequestMapping("/technologyRequirement/update_all")
    public Map<String,Object> updateAll(@Valid TechnologyRequirement requirement,
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
            boolean insert=processMonitoringService.updateTechnologyRequirement(requirement);

            if (insert){
                map.put("msg","OK");
                map.put("status",200);
            }else {
                map.put("msg","fail");
            }

        }

        return map;

    }


    @ResponseBody
    @RequestMapping("/technologyRequirement/update_requirement")
    public Map<String,Object> updateRequirement(String technologyRequirementId,
                                                String requirement){

        Map<String,Object> map=new HashMap<String, Object>();

        if (requirement==null||"".equals(requirement)){
            map.put("msg","error");
            map.put("status",100);
            return map;
        }

        boolean update=processMonitoringService.updateRequirement(technologyRequirementId,requirement);

        if (update){
            map.put("msg","OK");
            map.put("status",200);
        }else {
            map.put("msg","error");
            map.put("status",100);
        }

        return map;

    }


    /**删除*/
    @ResponseBody
    @RequestMapping("/technologyRequirement/delete_judge")
    public String deleteJudge(){
        return "";
    }

    @ResponseBody
    @RequestMapping("/technologyRequirement/delete_batch")
    public Map<String,Object> deleteBatch(String[] ids){

        Map<String,Object> map=new HashMap<String, Object>();

        boolean delete=processMonitoringService.deleteTechnologyRequirement(ids);

        if (delete){
            map.put("msg","OK");
            map.put("status",200);
        }else {
            map.put("msg","fail");
        }

        return map;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}
