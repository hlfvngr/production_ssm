package com.cskaoyan.erp.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String,Date> {

    //转换器 ： 把stirng转行为日期
    //什么时候回调？ 如果请求参数封装里有需要把字符串转行为Date类型，则就回调该函数，并且响应的字符串传入
    @Override
    public Date convert(String s) {


        System.out.println(s);
        Date parse =null;

        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");

        try {
              parse = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return parse;
    }
}
