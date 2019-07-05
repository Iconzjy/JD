package com.springmvc.service.Impl;

import com.springmvc.dao.OrderMapper;
import com.springmvc.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class ManageOrderImplTest {

    private ApplicationContext applicationContext;
    @Autowired
    private OrderMapper orderMapper;
    @Before
    public void setUserMapper() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        orderMapper = applicationContext.getBean(OrderMapper.class);
    }

    @Test
    public void addOrder() {
        Date date = new Date();
        Order order=new Order();
        order.setConsignee("123");
        order.setOrdername("1");
        order.setTrading("123");
        order.setOrderuser(1);
        order.setOrdertime(date);
        order.setOrderstate("交易完成");
        order.setOrderid(123);
        orderMapper.insert(order);
    }
}