package com.springmvc.service;

import com.springmvc.entity.Address;

public interface ManageAddress {

    //获取用户的收货地址
    Address getAddressByid(int id);

}
