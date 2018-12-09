package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Order;
import com.cskaoyan.erp.utils.page.PageModel;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrder(Order order, PageModel pageModel);

}
