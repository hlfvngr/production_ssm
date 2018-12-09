package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Order;
import com.cskaoyan.erp.mapper.OrderMapper;
import com.cskaoyan.erp.service.OrderService;
import com.cskaoyan.erp.utils.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    public List<Order> findAllOrder(Order order, PageModel pageModel) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("orderId",order.getOrderId());
        map.put("orderCustom",order.getOrderCustom());
        map.put("orderProduct",order.getOrderProduct());
        int count = orderMapper.count(map);
        if(count == 0){
            return null;
        }
        pageModel.setRecordCount(count);
        int offset = pageModel.getFirstLimitParam();
        int limit = pageModel.getRows();
        map.put("limit",limit);
        map.put("offset",offset);
        return orderMapper.selectByPage(map);
    }

    public boolean insertOrder(Order order) {
        return orderMapper.insert(order) != 0;
    }

    public boolean updateOrder(Order order) {
        return orderMapper.updateByPrimaryKey(order) != 0;
    }

    public boolean updateOrderNote(Order order) {
        return orderMapper.updateByPrimaryKey(order) != 0;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public boolean deleteOrder(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int ret = orderMapper.deleteByPrimaryKey(ids[i]);
            if(ret == 0){
                return false;
            }
        }
        return true;
    }

    public Order finOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

}
