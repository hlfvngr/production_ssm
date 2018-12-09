package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.bean.Product;
import com.cskaoyan.erp.service.ProductService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("productController")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //增加商品
    @RequestMapping("/add_judge")
    @ResponseBody
    public void add_judge(){}

    @RequestMapping("/add")
    public String add(){
        return "product_add";
    }

    @RequestMapping("/insert")//图片还没有处理
    @ResponseBody
    public Map<String,Object> insert(@Valid Product product, MultipartFile multipartFile, BindingResult bindingResult){
        Map<String,Object> result = new HashMap<String, Object>();
        if(bindingResult.hasErrors()){
            return null;
        }
        //multipartFile
        boolean b = productService.insertProduct(product);
        if(b){
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
    //修改商品
    @RequestMapping("/edit_judge")
    @ResponseBody
    public void edit_judge(){}

    @RequestMapping("/edit")
    public String edit(){
        return "product_edit";
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String,Object> update_note(@Valid Product product,BindingResult bindingResult){
        Map<String,Object> result = new HashMap<String, Object>();
        //合法性校验
        if(bindingResult.hasErrors()){
            return null;
        }
        boolean ret = productService.updateProductNote(product);
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
    public Map<String,Object> update_all( @Valid Product product,MultipartFile multipartFile,BindingResult bindingResult){
        Map<String,Object> result = new HashMap<String, Object>();
        if(bindingResult.hasErrors()){
            return null;
        }
        //multipartFile
        boolean b = productService.updateProduct(product);
        if(b){
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

    //查找商品
    @RequestMapping("/find")
    public String find(){
        return "product_list";
    }

    @RequestMapping("/list")
    @ResponseBody//这里的分页查询,注意一下
    public Map<String,Object> list(PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();
        Product product = new Product();
        List<Product> products = productService.findAllProduct(product, pageModel);
        result.put("rows",products);
        result.put("total",products.size());
        return result;
    }

    //获得所有商品的信息
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Product> get_data(){
        return productService.findAllProduct();
    }

    @RequestMapping("/get/{productId}")
    @ResponseBody
    public Map<String,Object> get(@PathVariable String productId){
        Map<String,Object> result = new HashMap<String, Object>();
        Product product = productService.findProductById(productId);
        result.put("rows",product);
        result.put("total",1);
        return result;
    }

    @RequestMapping("/search_product_by_productId")
    @ResponseBody
    public  Map<String,Object> search_product_by_productId(String searchValue, PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();
        Product product = new Product();
        product.setProductId(searchValue);
        List<Product> products = productService.findAllProduct(product, pageModel);
        result.put("rows",products);
        result.put("total",products.size());
        return result;
    }

    @RequestMapping("/search_product_by_productName")
    @ResponseBody
    public Map<String,Object> search_product_by_productName(String searchValue, PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();
        Product product = new Product();
        product.setProductName(searchValue);
        List<Product> products = productService.findAllProduct(product, pageModel);
        result.put("rows",products);
        result.put("total",products.size());
        return result;
    }

    @RequestMapping("/search_product_by_productType")
    @ResponseBody
    public Map<String,Object> search_product_by_productType(String searchValue, PageModel pageModel){
        Map<String,Object> result = new HashMap<String, Object>();
        Product product = new Product();
        product.setProductType(searchValue);
        List<Product> products = productService.findAllProduct(product, pageModel);
        result.put("rows",products);
        result.put("total",products.size());
        return result;
    }

    //删除商品
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete_judge(){}


    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String,Object> delete_batch(@RequestBody @RequestParam("ids") String ids_str){
        Map<String,Object> result = new HashMap<String, Object>();
        String[] ids = ids_str.split(",");
        //验证合法性
        boolean ret = productService.deleteProduct(ids);
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
