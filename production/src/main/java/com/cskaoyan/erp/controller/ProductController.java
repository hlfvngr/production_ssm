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
import java.util.List;

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
    public String insert(@RequestBody @Valid Product product, MultipartFile multipartFile, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product_add";
        }else {
            //multipartFile
            boolean b = productService.insertProduct(product);
            if(b){
                return "product_list";
            }else {
                return "product_add";
            }
        }
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
    public String update_note(@RequestBody Product product){
        //合法性校验
        boolean ret = productService.updateProductNote(product);
        if(ret){
            return "product_list";
        }else {
            return "forward:/update_note";
        }
    }

    @RequestMapping("/update_all")
    public String update_all(@RequestBody @Valid Product product,MultipartFile multipartFile,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "product_edit";
        }else {
            //multipartFile
            boolean b = productService.updateProduct(product);
            if(b){
                return "product_list";
            }else {
                return "product_edit";
            }
        }
    }

    //查找商品
    @RequestMapping("/find")
    public String find(){
        return "product_list";
    }

    @RequestMapping("/list")
    @ResponseBody//这里的分页查询,注意一下
    public List<Product> list(PageModel pageModel){
        Product product = new Product();
         return productService.findAllProduct(product,pageModel);
    }

    @RequestMapping("/get/{productId}")
    @ResponseBody
    public Product get(@PathVariable String productId){
        Product product = productService.findProductById(productId);
        return product;
    }

    @RequestMapping("/search_product_by_productId")
    @ResponseBody
    public  List<Product> search_product_by_productId(String searchValue, PageModel pageModel){
        Product product = new Product();
        product.setProductId(searchValue);
        List<Product> products = productService.findAllProduct(product, pageModel);
        return products;
    }

    @RequestMapping("/search_product_by_productName")
    @ResponseBody
    public  List<Product> search_product_by_productName(String searchValue, PageModel pageModel){
        Product product = new Product();
        product.setProductName(searchValue);
        List<Product> products = productService.findAllProduct(product, pageModel);
        return products;
    }

    @RequestMapping("/search_product_by_productType")
    @ResponseBody
    public  List<Product> search_product_by_productType(String searchValue, PageModel pageModel){
        Product product = new Product();
        product.setProductType(searchValue);
        List<Product> products = productService.findAllProduct(product, pageModel);
        return products;
    }

    //删除商品
    @RequestMapping("/delete_judge")
    public void delete_judge(){}


    @RequestMapping("/delete_batch")
    public String delete_batch(@RequestBody @RequestParam("ids") String ids_str){
        String[] ids = ids_str.split(",");
        //验证合法性
        boolean ret = productService.deleteProduct(ids);
        if(ret){
            return "product_list";
        }else {
            return "product_list";
        }
    }
}
