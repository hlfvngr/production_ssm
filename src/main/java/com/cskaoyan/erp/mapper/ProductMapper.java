package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Product;
import org.apache.ibatis.annotations.*;

public interface ProductMapper {
    @Delete({
        "delete from product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String productId);

    @Insert({
        "insert into product (product_id, product_name, ",
        "product_type, image, ",
        "note, status)",
        "values (#{productId,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
        "#{productType,jdbcType=VARCHAR}, #{image,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(Product record);

    int insertSelective(Product record);

    @Select({
        "select",
        "product_id, product_name, product_type, image, note, status",
        "from product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set product_name = #{productName,jdbcType=VARCHAR},",
          "product_type = #{productType,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Product record);
}