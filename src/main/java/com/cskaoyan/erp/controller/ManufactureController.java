package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Manufacture;
import com.cskaoyan.erp.bean.Order;
import com.cskaoyan.erp.bean.Technology;
import com.cskaoyan.erp.service.ManufactureService;
import com.cskaoyan.erp.service.OrderService;
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
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;
    @Autowired
    OrderService orderService;
   /* @Autowired
    TechnologyService technologyService;*/

    //查找生产计划
    @RequestMapping("/find")
    public String find(){
        return "manufacture_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Manufacture> list(PageModel pageModel){
        Manufacture manufacture = new Manufacture();
        List<Manufacture> manufactures = manufactureService.findManufacture(manufacture,pageModel);
        return manufactures;
    }

    @RequestMapping("/search_manufacture_by_manufactureSn")
    @ResponseBody
    public List<Manufacture> search_manufacture_by_manufactureSn(String searchValue,PageModel pageModel){
        Manufacture manufacture = new Manufacture();
        manufacture.setManufactureSn(searchValue);
        List<Manufacture> manufactures = manufactureService.findManufacture(manufacture, pageModel);
        return manufactures;
    }

    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public List<Manufacture> search_manufacture_by_manufactureOrderId(String searchValue,PageModel pageModel){
        Order order = orderService.finOrderById(searchValue);
        Manufacture manufacture = new Manufacture();
        manufacture.setOrder(order);
        List<Manufacture> manufactures = manufactureService.findManufacture(manufacture, pageModel);
        return manufactures;
    }

   /* @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public List<Manufacture> search_manufacture_by_manufactureTechnologyName(String searchValue,PageModel pageModel){
        Technology technology = technologyService.findTechnologyByName(searchValue);
        Manufacture manufacture = new Manufacture();
        manufacture.setTechnology(technology);
        List<Manufacture> manufactures = manufactureService.findManufacture(manufacture, pageModel);
        return manufactures;
    }*/

    //增加生产计划
    @RequestMapping("/add_judge")
    @ResponseBody
    public void add_judge(){}

    @RequestMapping("/add")
    public String add(){
        return "manufacture_add";
    }

    @RequestMapping("/insert")
    public String insert(@RequestBody @Valid Manufacture manufacture, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "manufacture_add";
        }else {
            boolean b = manufactureService.insertManufacture(manufacture);
            if(b){
                return "manufacture_list";
            }else {
                return "manufacture_add";
            }
        }
    }

    //修改生产计划
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void edit_judge(){}

    @RequestMapping("/edit")
    public String edit(){
        return "manufacture_edit";
    }

    @RequestMapping("/update_all")
    public String update_all(@RequestBody @Valid Manufacture manufacture,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "manufacture_edit";
        }else {
            boolean b = manufactureService.updateManufacture(manufacture);
            if(b){
                return "manufacture_list";
            }else {
                return "manufacture_edit";
            }
        }
    }

    //删除生产计划
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete_judge(){}

    @RequestMapping("/delete_batch")
    public String delete_batch(@RequestBody @RequestParam("ids") String ids_str){
        String[] ids = ids_str.split(",");
        boolean b = manufactureService.deleteManufacture(ids);
        if(b){
            return "manufacture_list";
        }else {
            return "manufacture_list";
        }
    }
}
