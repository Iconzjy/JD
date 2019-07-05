package com.springmvc.dao;

import com.springmvc.entity.Shoppingcart;

import java.util.List;

public interface ShoppingcartMapper {
    int deleteByPrimaryKey(Integer primarykey);

    int insert(Shoppingcart record);

    int insertSelective(Shoppingcart record);

    Shoppingcart selectByPrimaryKey(Integer primarykey);

    int updateByPrimaryKeySelective(Shoppingcart record);

    int updateByPrimaryKey(Shoppingcart record);

    List<Shoppingcart> selectByUserid(int userid);
}