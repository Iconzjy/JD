package com.springmvc.dao;

import com.springmvc.entity.Computer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerMapperTest {


    private ApplicationContext applicationContext;
    @Autowired
    private ComputerMapper computerMapper;
    @Before
    public void setUserMapper() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        computerMapper = applicationContext.getBean(ComputerMapper.class);
    }


    @Test
    public void selectByShoppingName() {
        List<Computer> computer = computerMapper.selectByShoppingName("xxx");
        for (Computer c:computer
             ) {
            System.out.println(c.getId()+" "+c.getColor());
        }
    }
}