package com.cskaoyan.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    //配合internalResourcesViewResolver进行使用
    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }
}
