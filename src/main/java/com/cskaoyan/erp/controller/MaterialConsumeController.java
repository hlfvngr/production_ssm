package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.MaterialConsume;
import com.cskaoyan.erp.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:  张娅迪
 * Date: 2018/12/06
 * Time: 下午 8:19
 * Detail requirement:
 * Method:
 */
/**
 * 处理物料消耗请求控制器
 * */
@Controller
@RequestMapping("materialConsume")
public class MaterialConsumeController {

    /**
     * 自动注入MaterialConsumeService
     * */
    @Autowired
    @Qualifier("materialConsumeService")
    MaterialConsumeService materialConsumeService;

    /**
     * 处理权限判断请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map edit_judge(HttpServletRequest request){
        HashMap hashMap = new HashMap();

        //权限判断

        return hashMap;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public Map add_judge(HttpServletRequest request){
        HashMap hashMap = new HashMap();

        //权限判断

        return hashMap;
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public Map delete_judge(HttpServletRequest request){
        HashMap hashMap = new HashMap();

        //权限判断

        return hashMap;
    }


    /**
     * 处理物料消耗列表显示请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("find")
    public String find(){
        return "/materialConsume_list";
    }

    /**
     * 处理增加物料消耗列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("add")
    public String add(){
        return "/materialConsume_add";
    }

    //insert
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(MaterialConsume materialConsume){
        return materialConsumeService.insert(materialConsume);
    }

    /**
     * 处理编辑物料消耗列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        return materialConsumeService.deleteByConsumeId(ids);

    }

    /**
     * 处理编辑物料消耗列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("edit")
    public String edit(){
        return "/materialConsume_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(MaterialConsume materialConsume){
        return materialConsumeService.updateByConsumeId(materialConsume);
    }


    /**
     * 处理物料消耗列表页面显示请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("list")
    @ResponseBody
    public Map list(@RequestParam Integer page, Integer rows,
                                HttpServletRequest request){
        MaterialConsume materialConsume = new MaterialConsume();

        return materialConsumeService.findMaterialConsumesByPage(materialConsume, page, rows);
    }

    /**
     * 处理物料消耗列表搜索请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("search_materialConsume_by_workId")
    @ResponseBody
    public Map search_materialConsume_by_workId(@RequestParam Integer page, Integer rows,
                                                   HttpServletRequest request){
        MaterialConsume materialConsume = new MaterialConsume();
        String searchValue = request.getParameter("searchValue");
        materialConsume.setWorkId(searchValue);

        return materialConsumeService.findMaterialConsumesByPage(materialConsume, page, rows);
    }

    @RequestMapping("search_materialConsume_by_consumeId")
    @ResponseBody
    public Map search_materialConsume_by_consumeId(@RequestParam Integer page, Integer rows,
                                                HttpServletRequest request){
        MaterialConsume materialConsume = new MaterialConsume();
        String searchValue = request.getParameter("searchValue");
        materialConsume.setConsumeId(searchValue);

        return materialConsumeService.findMaterialConsumesByPage(materialConsume, page, rows);
    }

    @RequestMapping("search_materialConsume_by_materialId")
    @ResponseBody
    public Map search_materialConsume_by_materialId(@RequestParam Integer page, Integer rows,
                                                   HttpServletRequest request){
        MaterialConsume materialConsume = new MaterialConsume();
        String searchValue = request.getParameter("searchValue");
        materialConsume.setMaterialId(searchValue);

        return materialConsumeService.findMaterialConsumesByPage(materialConsume, page, rows);
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(MaterialConsume materialConsume){

        return materialConsumeService.updateByConsumeId(materialConsume);
    }
}