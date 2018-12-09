package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    int deleteByCustomId(String customId);

    int insert(Customer customer);

    Customer selectByCustomId(String customId);

    int updateByCustomId(Customer customer);

    List<Customer> selectCustomers(@Param("params") Map<String, Object> params);

    Integer count(@Param("params") Map<String, Object> params);
}