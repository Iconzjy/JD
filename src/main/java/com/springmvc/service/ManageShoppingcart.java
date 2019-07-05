package com.springmvc.service;

import com.springmvc.entity.Shoppingcart;

import java.util.List;

public interface ManageShoppingcart {

    //返回一件商品
    Shoppingcart selectShoppingcart(int id);

    //查找某用户的购物车的商品
    List<Shoppingcart> listShoppingcart(int uerid);

    //删除购物车里的某件商品
    String deleteShoppingcart(int shoppingid);

    //判断购物车中是否存在这件商品
    boolean isExit(int id);

    //添加商品到购物车
    String addShoppingcart(Shoppingcart shoppingcart);

    //更改某见商品的数量
    Shoppingcart changeShoppingcart(int id, int count);

}
