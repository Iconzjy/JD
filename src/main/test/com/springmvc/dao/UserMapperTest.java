package com.springmvc.dao;

import com.springmvc.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {

    private ApplicationContext applicationContext;
    @Autowired
    private UserMapper userMapper;
    @Before
    public void setUserMapper() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        userMapper = applicationContext.getBean(UserMapper.class);
    }



    @Test
    public void insertSelective() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getId()+" "+user.getName()+" "+user.getPwd());
        userMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void selectByPrimaryKey() {
    }
}