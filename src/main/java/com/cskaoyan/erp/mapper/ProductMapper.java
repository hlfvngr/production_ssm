package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;


public interface ProductMapper {

    int insertSelective(Product record);

    int updateByPrimaryKeySelective(Product record);

    int insert(Product product);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKey(Product product);

    List<Product> selectAllProduct();

    int count(Map<String,Object> map);

    List<Product> selectByPage(Map<String, Object> params);

    Product selectProductByName(String productName);
}