package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Order;
import com.cskaoyan.erp.service.OrderService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /*//增加订单
    @RequestMapping("/add_judge")
    public String add_judge(){
        return "order_list";
    }

    @RequestMapping("/add")
    public String add(){

        return "order_list";
    }
    @RequestMapping("/insert")
    public String insert(){
        return "order_list";
    }*/

    //查找订单
    @RequestMapping("/find")
    public String find(){
        return "order_list";
    }

    @RequestMapping("/list")
    @ResponseBody//这里的分页查询,注意一下
    public List<Order> list(PageModel pageModel){
        Order order = new Order();
        return orderService.findAllOrder(order,pageModel);
    }

   /* //更新订单
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void edit_judge(){}

    @RequestMapping("/edit")
    public String edit(){
        return "order_edit";
    }

    @RequestMapping("/update_judge")
    @ResponseBody
    public String update_note(){

    }*/
    /*//删除订单
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge(){

    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public String delete_batch(){

    }*/
}
