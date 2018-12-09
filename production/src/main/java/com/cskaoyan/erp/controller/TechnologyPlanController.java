package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.bean.TechnologyPlan;
import com.cskaoyan.erp.bean.VO.TechnologyPlanVO;
import com.cskaoyan.erp.service.ProcessMonitoringService;
import com.cskaoyan.erp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @CreateDate: 2018/12/7 1:32
 * @需求:
 * @思路说明:
 */
@Controller
public class TechnologyPlanController {

    /**工艺计划*/

    @Autowired
    private ProcessMonitoringService processMonitoringService;


    /**显示*/
    @RequestMapping(value = "/technologyPlan/find")
    public String technologyPlanFind(){
        return "/technologyPlan_list";
    }

    @ResponseBody
    @RequestMapping("/technologyPlan/list")
    public Map<String,Object> technologyPlanList(PageModel pageModel){

        Map<String,Object> map=processMonitoringService.findTechnologyPlanList(pageModel);

        return map;
    }



    /**搜索*/
    @ResponseBody
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyPlanId")
    public Map<String,Object> searchById(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchPlanByPlanId(searchValue,pageModel);
        return map;
    }

    @ResponseBody
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyName")
    public Map<String,Object> searchByName(String searchValue, PageModel pageModel){

        Map<String,Object> map=processMonitoringService.searchPlanByTechnologyName(searchValue,pageModel);
        return map;
    }


    /**回显*/
    @ResponseBody
    @RequestMapping("/technology/get_data")
    public List<Technology> getData(){

        List<Technology> list=processMonitoringService.findAllTechnology();
        return list;
    }


    /**新增*/
    @ResponseBody
    @RequestMapping("/technologyPlan/add_judge")
    public String addJudge(){
        return "";
    }

    @RequestMapping("/technologyPlan/add")
    public String add(){
        return "/technologyPlan_add";
    }

    @ResponseBody
    @RequestMapping("/technologyPlan/insert")
    public Map<String,Object> insertTechnologyPlan(@Valid TechnologyPlan technologyPlan,
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
            boolean insert=processMonitoringService.insertTechnologyPlan(technologyPlan);

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
    @RequestMapping("/technologyPlan/edit_judge")
    public String editJudge(){
        return "";
    }

    @RequestMapping("/technologyPlan/edit")
    public String edit(){
        return "/technologyPlan_edit";
    }

    @ResponseBody
    @RequestMapping("/technologyPlan/update_all")
    public Map<String,Object> updateAll(@Valid TechnologyPlan technologyPlan,
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
            boolean update=processMonitoringService.updateTechnologyPlan(technologyPlan);

            if (update){
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
    @RequestMapping("/technologyPlan/delete_judge")
    public String deleteJudge(){
        return "";
    }

    @ResponseBody
    @RequestMapping("/technologyPlan/delete_batch")
    public Map<String,Object> deleteBatch(String[] ids){

        Map<String,Object> map=new HashMap<String, Object>();

        boolean delete=processMonitoringService.deleteTechnologyPlan(ids);

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


    /**开放接口*/

    @ResponseBody
    @RequestMapping("/technologyPlan/get/{technologyPlanId}")
    public TechnologyPlanVO getTechnologyPlan(@PathVariable("technologyPlanId") String technologyPlanId){

        TechnologyPlanVO technologyPlanVO=processMonitoringService.getTechnologyPlanById(technologyPlanId);

        return technologyPlanVO;

    }



}
