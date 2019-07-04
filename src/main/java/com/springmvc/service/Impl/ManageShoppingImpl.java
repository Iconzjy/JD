package com.springmvc.service.Impl;

import com.springmvc.dao.ComputerMapper;
import com.springmvc.dao.ShopMapper;
import com.springmvc.entity.Computer;
import com.springmvc.entity.Shop;
import com.springmvc.service.ManageShopping;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ManageShoppingImpl implements ManageShopping {
    @Autowired
    ShopMapper shopMapper;
    ComputerMapper computerMapper;

    @Override
    public List<Pair<Shop, Computer>> findShopping(String shoppingName) {
        try{
            List<Pair<Shop, Computer>> pairList=new LinkedList<>();
            List<Computer> computerList=computerMapper.selectByShoppingName(shoppingName);
            for (Computer c: computerList) {
                Pair<Shop, Computer> pair;
                Shop shop = shopMapper.selectByPrimaryKey(c.getId());
                pair = new Pair<>(shop,c);
                pairList.add(pair);
            }
            return pairList;
        }catch (Exception e){
            return null;
        }finally {

        }
    }

    @Override
    public Shop selectShopByid(int id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    @Override
    public String addShopping(Shop shop, Computer computer){
        try {
            if(shop.getId().equals("")&&computer.getId().equals(""))
                return "主键不能为空";
            shopMapper.insertSelective(shop);
            computerMapper.insertSelective(computer);
            return "添加成功";
        }catch (Exception e){
            return "addShopping（） 出现异常";
        }finally {

        }
    }

    @Override
    public String deleteShopping(int shoppingID) {
        try {
            shopMapper.deleteByPrimaryKey(shoppingID);
            computerMapper.deleteByPrimaryKey(shoppingID);
            return "删除成功成功";
        }catch (Exception e){
            return "删除异常";
        }finally {
            if(shopMapper.selectByPrimaryKey(shoppingID).getId()!=null){
                shopMapper.deleteByPrimaryKey(shoppingID);
            }
            if(computerMapper.selectByPrimaryKey(shoppingID).getId()!=null){
                computerMapper.deleteByPrimaryKey(shoppingID);
            }
        }
    }
}
