package com.springmvc.service;

import com.springmvc.entity.Computer;

import java.util.List;

public interface ManageComputer {

    //通过商品名称获取电脑的类别
    List<Computer> getComputers(String name);

    //通过id过去电脑信息
    Computer selectComputerByid(int id);
}
