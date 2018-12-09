package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:  张娅迪
 * Date: 2018/12/08
 * Time: 上午 11:57
 * Detail requirement:
 * Method:
 */
public interface CustomService {

    Map deleteByCustomId(String[] customIds);

    Map insert(Customer customer);

    //改
    Map updateByCustomId(Customer customer);

    //查
    Customer findByCustomId(String materialId);

    Map findCustomersByPage(Customer customer, Integer page , Integer rows);

    Integer count(Customer customer);

    List findMaterials();
}
