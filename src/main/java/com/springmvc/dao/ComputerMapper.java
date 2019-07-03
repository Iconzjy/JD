package com.springmvc.dao;

import com.springmvc.entity.Computer;

import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);

    List<Computer> selectByShoppingName(String name);
}