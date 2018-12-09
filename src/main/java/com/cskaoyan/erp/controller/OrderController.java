package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Customer;
import com.cskaoyan.erp.bean.Order;
import com.cskaoyan.erp.bean.Product;
import com.cskaoyan.erp.service.OrderService;
import com.cskaoyan.erp.service.ProductService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
   /* @Autowired
    CustomerService customerService;*/
    @Autowired
    ProductService productService;

    //增加订单
    @RequestMapping("/add_judge")
    @ResponseBody
    public void add_judge(){}

    @RequestMapping("/add")
    public String add(){
        return "order_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(@Valid Order order, MultipartFile multipartFile, BindingResult bindingResult){
        Map<String,Object> result = new HashMap<String, Object>();
        if(bindingResult.hasErrors()){
            return null;
        }
            //图片的处理
        boolean ret = orderService.insertOrder(order);
        if(ret){
            result.put("status",200);
            result.put("msg","OK");
            result.put("data",null);
         }else {
            result.put("status",100);
            result.put("msg","fail");
            result.put("data",null);
        }
        return result;
    }



    //查找订单
    @RequestMapping("/find")
    public String find(){
        return "order_list";
    }

    @RequestMapping("/list")
    @ResponseBody//这里的分页查询,注意一下
    public Map<String,Object>  list(PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();

        Order order = new Order();
        List<Order> orders = orderService.findAllOrder(order, pageModel);

        result.put("rows",orders);
        result.put("total",orders.size());
        return result;
    }

    @RequestMapping("/search_product_by_orderId")
    @ResponseBody
    public  Map<String,Object>  search_product_by_orderId(String searchValue, PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();

        Order order = new Order();
        order.setOrderId(searchValue);
        List<Order> orders = orderService.findAllOrder(order, pageModel);

        result.put("rows",orders);
        result.put("total",orders.size());
        return result;
    }

   /* @RequestMapping("/search_product_by_orderCustom")
    @ResponseBody
    public   Map<String,Object> search_product_by_orderCustom(String searchValue, PageModel pageModel) {
        Map<String, Object> result = new HashMap<String, Object>();

        Customer customer = customerService.findCustomByName(searchValue);
        Order order = new Order();
        order.setOrderCustom(customer);
        List<Order> orders = orderService.findAllOrder(order, pageModel);

        result.put("rows", orders);
        result.put("total", orders.size());
        return result;
    }*/

    @RequestMapping("/search_product_by_orderProduct")
    @ResponseBody
    public  Map<String,Object> search_product_by_productType(String searchValue, PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();

        Product product = productService.findProductByName(searchValue);
        Order order = new Order();
        order.setOrderProduct(product);
        List<Order> orders = orderService.findAllOrder(order, pageModel);

        result.put("rows",orders);
        result.put("total",orders.size());
        return result;
    }

    //更新订单
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void edit_judge(){}

    @RequestMapping("/edit")
    public String edit(){
        return "order_edit";
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String,Object> update_note(@RequestBody @Valid Order order, BindingResult bindingResult){
        Map<String,Object> result = new HashMap<String, Object>();

        if(bindingResult.hasErrors()){
            return null;
        }
        boolean ret = orderService.updateOrderNote(order);
        if(ret){
            result.put("status",200);
            result.put("msg","OK");
            result.put("data",null);
        }else {
            result.put("status",100);
            result.put("msg","fail");
            result.put("data",null);
        }

        return result;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String,Object>  update_all(@RequestBody @Valid Order order, MultipartFile multipartFile, BindingResult bindingResult){
        Map<String,Object> result = new HashMap<String, Object>();

        if(bindingResult.hasErrors()){
            return null;
        }
        boolean ret = orderService.updateOrder(order);
        if(ret){
            result.put("status",200);
            result.put("msg","OK");
            result.put("data",null);
        }else {
            result.put("status",100);
            result.put("msg","fail");
            result.put("data",null);
        }

        return result;
    }
    //删除订单
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete_judge(){}

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String,Object> delete_batch(@RequestBody @RequestParam("ids") String ids_str){
        Map<String,Object> result = new HashMap<String, Object>();

        String[] ids = ids_str.split(",");
        boolean ret = orderService.deleteOrder(ids);

        if(ret){
            result.put("status",200);
            result.put("msg","OK");
            result.put("data",null);
        }else {
            result.put("status",100);
            result.put("msg","fail");
            result.put("data",null);
        }

        return result;
    }
}
