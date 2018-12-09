package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    @Delete({
        "delete from product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String productId);

    int insert(Product product);

    @Select({
        "select",
        "product_id, product_name, product_type, image, note, status",
        "from product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKey(Product record);

    List<Product> selectAllProduct();

    int count(Map<String,Object> map);

    List<Product> selectByPage(Map<String, Object> params);
}