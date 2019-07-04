package com.springmvc.service;

import com.springmvc.entity.Shoppingcart;

import java.util.List;

public interface ManageShoppingcart {

    //查找某用户的购物车的商品
    List<Shoppingcart> listShoppingcart(int uerid);

    //删除购物车里的某件商品
    String deleteShoppingcart(int shoppingid);

    //添加商品到购物车
    String addShoppingcart(Shoppingcart shoppingcart);

    //

}
