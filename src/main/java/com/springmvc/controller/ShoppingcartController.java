package com.springmvc.controller;


import com.springmvc.entity.Address;
import com.springmvc.entity.Shoppingcart;
import com.springmvc.entity.ShoppingcartWithOther;
import com.springmvc.entity.User;
import com.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("")
public class ShoppingcartController {

    @Autowired
    private ManageShopping manageShopping;
    @Autowired
    private ManageUser manageUser;
    @Autowired
    private ManageComputer manageComputer;
    @Autowired
    private ManageShoppingcart manageShoppingcart;
    @Autowired
    private ManageAddress manageAddress;

    @RequestMapping(value = "/deletegoods",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView deleteGoods(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        int shoppingcartid=Integer.parseInt(request.getParameter("shoppingid"));
        double totalprice=0;
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("flow1");
        manageShoppingcart.deleteShoppingcart(shoppingcartid);
        List<Shoppingcart> shoppingcartList;
        shoppingcartList=manageShoppingcart.listShoppingcart(userid);
        List<ShoppingcartWithOther> shoppingcartWithOthers=new LinkedList<ShoppingcartWithOther>();
        for (Shoppingcart s:shoppingcartList) {
            ShoppingcartWithOther other=new ShoppingcartWithOther(s,manageShopping.selectShopByid(s.getShoppingid()),manageComputer.selectComputerByid(s.getShoppingid()));
            shoppingcartWithOthers.add(other);
            double aaa=s.getPrice()*s.getNumber();
            totalprice=totalprice+aaa;
        }
        mav.addObject("totalprice",totalprice);
        mav.addObject("user",user);
        mav.addObject("shoppingcarts",shoppingcartWithOthers);
        return mav;

    }

    //这个是用于更新商品数量的操作
    @RequestMapping(value = "/updategoods",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView updateGoods(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        int shoppingcartid=Integer.parseInt(request.getParameter("shoppingid"));
        int count=Integer.parseInt(request.getParameter("myamount"));
        List<Shoppingcart> shoppingcartList;
        shoppingcartList=manageShoppingcart.listShoppingcart(userid);
        for (Shoppingcart s:shoppingcartList){
            Shoppingcart shoppingcart=manageShoppingcart.selectShoppingcart(shoppingcartid);
            if(s.getShoppingid().equals(shoppingcart.getShoppingid())){
                manageShoppingcart.changeShoppingcart(s.getPrimarykey(),count);
                break;
            }
        }
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("flow1");
        List<ShoppingcartWithOther> shoppingcartWithOthers=new LinkedList<ShoppingcartWithOther>();
        shoppingcartList=manageShoppingcart.listShoppingcart(userid);
        double totalprice=0;
        for (Shoppingcart s:shoppingcartList) {
            ShoppingcartWithOther other=new ShoppingcartWithOther(s,manageShopping.selectShopByid(s.getShoppingid()),manageComputer.selectComputerByid(s.getShoppingid()));
            shoppingcartWithOthers.add(other);
            double aaa=s.getPrice()*s.getNumber();
            totalprice=totalprice+aaa;
        }
        mav.addObject("totalprice",totalprice);
        mav.addObject("user",user);
        mav.addObject("shoppingcarts",shoppingcartWithOthers);
        return mav;
    }

    //这个是结算按钮
    @RequestMapping(value = "/jiesuangoods",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView jiesuanGoods(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("flow2");
        Address address = new Address();
        address=manageAddress.getAddressByid(userid);

        List<ShoppingcartWithOther> shoppingcartWithOthers=new LinkedList<ShoppingcartWithOther>();
        List<Shoppingcart> shoppingcartList;

        int zongshuliang = 0;//结算的总数量
        double zongjiner = 0.0;//结算总金额
        double yingfuzonge = 0.0;//应付总额


        shoppingcartList=manageShoppingcart.listShoppingcart(userid);
        for (Shoppingcart s:shoppingcartList) {
            ShoppingcartWithOther other=new ShoppingcartWithOther(s,manageShopping.selectShopByid(s.getShoppingid()),manageComputer.selectComputerByid(s.getShoppingid()));
            shoppingcartWithOthers.add(other);
            zongshuliang = zongshuliang+other.getShoppingcart().getNumber();
            zongjiner = zongjiner+other.getShoppingcart().getAllprice()*other.getShoppingcart().getNumber();
        }
        yingfuzonge=zongjiner;
        mav.addObject("user",user);
        mav.addObject("address",address);
        mav.addObject("shoppingcart",shoppingcartWithOthers);
        mav.addObject("yingfuzonge",yingfuzonge);
        mav.addObject("zongjiner",zongjiner);
        mav.addObject("yingfuzonge",yingfuzonge);
        return mav;
    }

}
