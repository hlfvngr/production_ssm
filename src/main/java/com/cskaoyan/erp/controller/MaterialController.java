package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Material;
import com.cskaoyan.erp.bean.MaterialReceive;
import com.cskaoyan.erp.service.MaterialService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("material")
public class MaterialController {

    /**
     * 自动注入MaterialService
     * */
    @Autowired
    @Qualifier("materialService")
    MaterialService materialService;

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
     * 处理物料列表显示请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("find")
    public String find(){
        return "/material_list";
    }

    /**
     * 处理增加物料列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("add")
    public String add(){
        return "/material_add";
    }

    //insert
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Material material){
        return materialService.insert(material);
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
        return materialService.deleteByMaterialId(ids);
    }

    /**
     * 处理编辑物料消耗列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("edit")
    public String edit(){
        return "/material_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Material material){
        return materialService.updateByMaterialId(material);
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
        Material material = new Material();

        return materialService.findMaterialsByPage(material, page, rows);

    }

    /**
     * 处理物料列表搜索请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("search_material_by_materialId")
    @ResponseBody
    public Map search_material_by_materialId(@RequestParam Integer page, Integer rows,
                                                   HttpServletRequest request){
        Material material = new Material();
        String searchValue = request.getParameter("searchValue");
        material.setMaterialId(searchValue);

        return materialService.findMaterialsByPage(material, page, rows);
    }

    @RequestMapping("search_material_by_materialType")
    @ResponseBody
    public Map search_material_by_materialType(@RequestParam Integer page, Integer rows,
                                                HttpServletRequest request){
        Material material = new Material();
        String searchValue = request.getParameter("searchValue");
        material.setMaterialType(searchValue);

        return materialService.findMaterialsByPage(material, page, rows);
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(Material material){

        return materialService.updateByMaterialId(material);
    }

    //获取所有物料信息
    @RequestMapping("get_data")
    @ResponseBody
    public List get_data(){
        return materialService.findMaterials();
    }

    //get
    @RequestMapping("get/{materialId}")
    @ResponseBody
    public Material get(@PathVariable("materialId") String materialId){
        return materialService.findByMaterialId(materialId);
    }
}