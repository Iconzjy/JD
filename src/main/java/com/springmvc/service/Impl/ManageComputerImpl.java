package com.springmvc.service.Impl;


import com.springmvc.dao.ComputerMapper;
import com.springmvc.entity.Computer;
import com.springmvc.service.ManageComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManageComputerImpl implements ManageComputer {

    @Autowired
    ComputerMapper computerMapper;
    @Override
    public List<Computer> getComputers(String name) {
        return computerMapper.selectByShoppingName(name);
    }

    @Override
    public Computer selectComputerByid(int id) {
        return computerMapper.selectByPrimaryKey(id);
    }
}
