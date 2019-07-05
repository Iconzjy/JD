package com.springmvc.service.Impl;

import com.springmvc.dao.AddressMapper;
import com.springmvc.entity.Address;
import com.springmvc.service.ManageAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ManageAddressImpl implements ManageAddress {

    @Autowired
    AddressMapper addressMapper;
    @Override
    public Address getAddressByid(int id) {
        return addressMapper.selectByPrimaryKey(id);
    }
}
