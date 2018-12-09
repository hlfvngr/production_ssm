package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Customer;
import com.cskaoyan.erp.mapper.CustomerMapper;
import com.cskaoyan.erp.service.CustomService;
import com.cskaoyan.erp.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("customService")
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Map deleteByCustomId(String[] customIds) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";
        Boolean flag = true;

        for (String id:customIds ) {
            int i = customerMapper.deleteByCustomId(id);
            if (i<=0){
                flag = false;
                break;
            }
        }

        if (flag){
            status = 200;
            msg = "OK";
            data = null;
        }

        resultMap.put("status", status);
        resultMap.put("msg", msg);
        resultMap.put("data",data);

        return resultMap;
    }

    @Override
    public Map insert(Customer customer) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = customerMapper.insert(customer);

        if (i>0){
            status = 200;
            msg = "OK";
            data = null;
        }

        resultMap.put("status", status);
        resultMap.put("msg", msg);
        resultMap.put("data",data);

        return resultMap;
    }

    @Override
    public Map updateByCustomId(Customer customer) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int status = -1;
        String msg = new String();
        String data = "fail";

        int i = customerMapper.updateByCustomId(customer);

        if (i>0){
            status = 200;
            msg = "OK";
            data = null;
        }

        resultMap.put("status", status);
        resultMap.put("msg", msg);
        resultMap.put("data",data);

        return resultMap;
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findByCustomId(String customId) {
        return customerMapper.selectByCustomId(customId);
    }

    @Transactional(readOnly = true)
    @Override
    public Map findCustomersByPage(Customer customer, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        PageModel pageModel = new PageModel();
        List<Customer> customers = new ArrayList<>();

        map.put("customer",customer);

        int recordCount = customerMapper.count(map);
        if (recordCount>0){
            pageModel.setRecordCount(recordCount);

            if (page>0)
                pageModel.setPage(page);

            if (rows>0)
                pageModel.setRows(rows);

            int limitParam = pageModel.getFirstLimitParam();
            map.put("limitParam",limitParam);
            map.put("rows",rows);

            customers = customerMapper.selectCustomers(map);
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("total",customers.size());
        resultMap.put("rows",customers);

        return resultMap;
    }

    @Transactional(readOnly = true)
    @Override
    public Integer count(Customer customer) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer",customer);

        Integer count = customerMapper.count(map);
        return count.intValue();
    }

    @Transactional(readOnly = true)
    @Override
    public List findMaterials() {
        return customerMapper.selectCustomers(new HashMap<>());
    }
}