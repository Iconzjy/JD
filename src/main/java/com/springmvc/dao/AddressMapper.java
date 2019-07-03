package com.springmvc.dao;

import com.springmvc.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer primarykey);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer primarykey);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}