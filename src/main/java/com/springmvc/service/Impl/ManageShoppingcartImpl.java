package com.springmvc.service.Impl;

import com.springmvc.dao.ShoppingcartMapper;
import com.springmvc.entity.Shoppingcart;
import com.springmvc.service.ManageShoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManageShoppingcartImpl implements ManageShoppingcart {
    @Autowired
    ShoppingcartMapper shoppingcartMapper;


    @Override
    public Shoppingcart selectShoppingcart(int id) {
        return shoppingcartMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Shoppingcart> listShoppingcart(int uerid){
        return shoppingcartMapper.selectByUserid(uerid);
    }

    @Override
    public String deleteShoppingcart(int shoppingid){
        try {
            shoppingcartMapper.deleteByPrimaryKey(shoppingid);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }
    }

    @Override
    public boolean isExit(int id) {
        if(shoppingcartMapper.selectByPrimaryKey(id)!=null){
            return true;
        }
        return false;
    }

    @Override
    public String addShoppingcart(Shoppingcart shoppingcart){
        try {
            shoppingcartMapper.insertSelective(shoppingcart);
            return "添加成功";
        }catch (Exception e){
            return "添加失败";
        }
    }

    //id就是表里面的primarykey
    @Override
    public Shoppingcart changeShoppingcart(int id, int count) {
        Shoppingcart shoppingcart=shoppingcartMapper.selectByPrimaryKey(id);
        shoppingcart.setNumber(count);
        shoppingcartMapper.updateByPrimaryKeySelective(shoppingcart);
        return shoppingcartMapper.selectByPrimaryKey(id);
    }


}
