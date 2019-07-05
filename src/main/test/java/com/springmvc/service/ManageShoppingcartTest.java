package com.springmvc.service;

import com.springmvc.dao.ShoppingcartMapper;
import com.springmvc.entity.Shoppingcart;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ManageShoppingcartTest {

    private ApplicationContext applicationContext;
    @Autowired
    private ShoppingcartMapper manageShoppingcart;
    @Before
    public void setUserMapper() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        manageShoppingcart = applicationContext.getBean(ShoppingcartMapper.class);
    }

    @Test
    public void addShoppingcart() {
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setUserid(1);
        shoppingcart.setNumber(Integer.parseInt(String.valueOf(1)));
        shoppingcart.setFreight((double) 10);
        shoppingcart.setAllprice((double)100);
        shoppingcart.setShoppingid(1);
        manageShoppingcart.insertSelective(shoppingcart);
    }
}