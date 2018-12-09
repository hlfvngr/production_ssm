package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.bean.VO.*;
import com.cskaoyan.erp.service.Impl.ProcessMonitoringServiceImpl;
import com.cskaoyan.erp.service.ProcessMonitoringService;
import com.cskaoyan.erp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/6 9:37
 * @需求:
 * @思路说明:
 */

@Controller
public class TechnologyController {


    @Autowired
    private ProcessMonitoringService processMonitoringService;


    /**工艺管理*/

    @RequestMapping(value = "/technology/find")
    public String technologyFind(){
        return "/technology_list";
    }

    @ResponseBody
    @RequestMapping("/technology/list")
    public Map<String,Object> technologyList(PageModel pageModel){

        Map<String,Object> map=processMonitoringService.findTechnologyList(pageModel);

        return map;
    }

    /**新增*/

    @ResponseBody
    @RequestMapping("/technology/add_judge")
    public String addJudge(){
        return "";
    }

    @RequestMapping("/technology/add")
    public String add(){
        return "/technology_add";
    }


    @ResponseBody
    @RequestMapping("/technology/insert")
    public Map<String,Object> insertTechnology(@Valid Technology technology,
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
            boolean insert=processMonitoringService.insertTechnology(technology);

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
    @RequestMapping("/technology/delete_judge")
    public String deleteJudge(){
        return "";
    }

    @ResponseBody
    @RequestMapping("/technology/delete_batch")
    public Map<String,Object> deleteBatch(String[] ids){

        Map<String,Object> map=new HashMap<String, Object>();

        boolean delete=processMonitoringService.deleteTechnology(ids);

        if (delete){
            map.put("msg","OK");
            map.put("status",200);
        }else {
            map.put("msg","fail");
        }

        return map;
    }


    /**修改*/
    @ResponseBody
    @RequestMapping("/technology/edit_judge")
    public String editJudge(){
        return "/technology_edit";
    }

    @RequestMapping("/technology/edit")
    public String edit(){
        return "/technology_edit";
    }

    @ResponseBody
    @RequestMapping("/technology/update_all")
    public Map<String,Object> updateAll(@Valid Technology technology,
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
            boolean insert=processMonitoringService.updateByPrimaryKey(technology);

            if (insert){
                map.put("msg","OK");
                map.put("status",200);
            }else {
                map.put("msg","fail");
            }

        }

        return map;
    }


    /**搜索*/
    @ResponseBody
    @RequestMapping("/technology/search_technology_by_technologyId")
    public Map<String,Object> searchById(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchTechnologyByTechnologyId(searchValue,pageModel);
        return map;
    }

    @ResponseBody
    @RequestMapping("/technology/search_technology_by_technologyName")
    public Map<String,Object> searchByName(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchTechnologyByTechnologyName(searchValue,pageModel);
        return map;
    }


    /**开放接口*/

    @ResponseBody
    @RequestMapping("/technology/get/{technologyId}")
    public Technology getTechnology(@PathVariable("technologyId") String technologyId){

        Technology technology=processMonitoringService.getTechnologyById(technologyId);

        return technology;

    }

}
