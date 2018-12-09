package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Customer;
import com.cskaoyan.erp.service.CustomService;
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
 * Date: 2018/12/08
 * Time: 下午 12:41
 * Detail requirement:
 * Method:
 */
@Controller
@RequestMapping("custom")
public class CustomController {
    /**
     * 自动注入customService
     * */
    @Autowired
    @Qualifier("customService")
    CustomService customService;

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
        return "/custom_list";
    }

    /**
     * 处理增加物料列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("add")
    public String add(){
        return "/custom_add";
    }

    //insert
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Customer customer){
        return customService.insert(customer);
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
        return customService.deleteByCustomId(ids);
    }

    /**
     * 处理编辑客户列请求
     * @param:
     * @param:
     * @return 跳转的视图
     * */
    @RequestMapping("edit")
    public String edit(){
        return "/custom_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Customer customer){
        return customService.updateByCustomId(customer);
    }


    /**
     * 处理客户列表页面显示请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("list")
    @ResponseBody
    public Map list(@RequestParam Integer page, Integer rows,
                    HttpServletRequest request){
        Customer customer = new Customer();

        return customService.findCustomersByPage(customer, page, rows);
    }

    /**
     * 处理物料列表搜索请求
     * @param:
     * @param:
     * @return json数据
     * */
    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public Map search_custom_by_customId(@RequestParam Integer page, Integer rows,
                                             HttpServletRequest request){
        Customer customer = new Customer();
        String searchValue = request.getParameter("searchValue");
        customer.setCustomId(searchValue);

        return customService.findCustomersByPage(customer, page, rows);
    }

    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public Map search_custom_by_customName(@RequestParam Integer page, Integer rows,
                                               HttpServletRequest request){
        Customer customer = new Customer();
        String searchValue = request.getParameter("searchValue");
        customer.setCustomName(searchValue);

        return customService.findCustomersByPage(customer, page, rows);
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(Customer customer){

        return customService.updateByCustomId(customer);
    }

    //获取所有物料信息
    @RequestMapping("get_data")
    @ResponseBody
    public List get_data(){
        return customService.findMaterials();
    }

    //get
    @RequestMapping("get/{customId}")
    @ResponseBody
    public Customer get(@PathVariable("customId") String customId) {
        return customService.findByCustomId(customId);
    }
}