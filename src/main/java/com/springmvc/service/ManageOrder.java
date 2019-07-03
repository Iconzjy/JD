package com.springmvc.service;

import com.springmvc.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

public interface ManageOrder {

    //添加订单
    String addOrder(Order order) throws Exception ;

    //删除订单记录
    String deleteOrder(int orderid) throws Exception ;



}
