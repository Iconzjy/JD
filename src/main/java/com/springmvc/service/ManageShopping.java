package com.springmvc.service;

import com.springmvc.entity.Computer;
import com.springmvc.entity.Order;
import com.springmvc.entity.Shop;
import javafx.util.Pair;

import java.util.List;

public interface ManageShopping {

    //查找商品，通过商品名称
    List<Pair<Shop,Computer>> findShopping(String shoppingName) ;

    //这个是返回shop表的信息，因为每一个Computer都对应一个shop的值，shop是所有商品的公共部分
    Shop selectShopByid(int id)throws Exception;

    //添加商品
    String addShopping(Shop shop, Computer computer);

    //删除商品
    String deleteShopping(int shoppingID);

    //

}
