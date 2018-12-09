package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.MaterialReceive;
import com.cskaoyan.erp.service.MaterialReceiveService;
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
 * Date: 2018/12/08
 * Time: 上午 10:15
 * Detail requirement:
 * Method:
 */
@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {
    /**
     * 自动注入materialReceiveService
     * */
    @Autowired
    @Qualifier("materialReceiveService")
    MaterialReceiveService materialReceiveService;

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
        return "/materialReceive_list";
    }

    /**
     * 处理增加物料消耗列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("add")
    public String add(){
        return "/materialReceive_add";
    }

    //insert
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(MaterialReceive materialReceive){
        return materialReceiveService.insert(materialReceive);
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
        return materialReceiveService.deleteByReceiveId(ids);

    }

    /**
     * 处理编辑物料消耗列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("edit")
    public String edit(){
        return "/materialReceive_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(MaterialReceive materialReceive){
        return materialReceiveService.updateByReceiveId(materialReceive);
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
        MaterialReceive materialReceive = new MaterialReceive();

        return materialReceiveService.findMaterialReceivesByPage(materialReceive, page, rows);
    }

    /**
     * 处理物料消耗列表搜索请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("search_materialReceive_by_materialId")
    @ResponseBody
    public Map search_materialConsume_by_workId(@RequestParam Integer page, Integer rows,
                                                HttpServletRequest request){
        MaterialReceive materialReceive = new MaterialReceive();
        String searchValue = request.getParameter("searchValue");
        materialReceive.setMaterialId(searchValue);

        return materialReceiveService.findMaterialReceivesByPage(materialReceive, page, rows);
    }

    @RequestMapping("search_materialReceive_by_receiveId")
    @ResponseBody
    public Map search_materialReceive_by_receiveId(@RequestParam Integer page, Integer rows,
                                                   HttpServletRequest request){
        MaterialReceive materialReceive = new MaterialReceive();
        String searchValue = request.getParameter("searchValue");
        materialReceive.setReceiveId(searchValue);

        return materialReceiveService.findMaterialReceivesByPage(materialReceive, page, rows);
    }


    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(MaterialReceive materialReceive){

        return materialReceiveService.updateByReceiveId(materialReceive);
    }
}