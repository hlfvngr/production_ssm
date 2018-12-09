package com.cskaoyan.erp.mapper;

import com.cskaoyan.erp.bean.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    @Delete({
        "delete from c_order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    @Insert({
        "insert into c_order (order_id, custom_id, ",
        "product_id, order_date, ",
        "request_date, note, ",
        "quantity, unit_price, ",
        "unit, image, file, ",
        "status)",
        "values (#{orderId,jdbcType=VARCHAR}, #{customId,jdbcType=VARCHAR}, ",
        "#{productId,jdbcType=VARCHAR}, #{orderDate,jdbcType=TIMESTAMP}, ",
        "#{requestDate,jdbcType=TIMESTAMP}, #{note,jdbcType=VARCHAR}, ",
        "#{quantity,jdbcType=INTEGER}, #{unitPrice,jdbcType=DECIMAL}, ",
        "#{unit,jdbcType=VARCHAR}, #{image,jdbcType=VARCHAR}, #{file,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(Order record);

    int insertSelective(Order record);

    @Select({
        "select",
        "order_id, custom_id, product_id, order_date, request_date, note, quantity, unit_price, ",
        "unit, image, file, status",
        "from c_order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.cskaoyan.erp.mapper.OrderMapper.BaseResultMap")
    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update c_order",
        "set custom_id = #{customId,jdbcType=VARCHAR},",
          "product_id = #{productId,jdbcType=VARCHAR},",
          "order_date = #{orderDate,jdbcType=TIMESTAMP},",
          "request_date = #{requestDate,jdbcType=TIMESTAMP},",
          "note = #{note,jdbcType=VARCHAR},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "unit_price = #{unitPrice,jdbcType=DECIMAL},",
          "unit = #{unit,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "file = #{file,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Order record);

    int count(Map<String, Object> map);

    List<Order> selectByPage(Map<String, Object> map);
}