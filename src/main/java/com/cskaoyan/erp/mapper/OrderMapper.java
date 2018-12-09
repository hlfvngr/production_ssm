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

    int insert(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKey(Order order);

    int count(Map<String, Object> map);

    List<Order> selectByPage(Map<String, Object> map);

    List<Order> findAllOrder();

}