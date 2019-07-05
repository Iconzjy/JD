package com.springmvc.controller;

import com.springmvc.entity.Order;
import com.springmvc.entity.Shoppingcart;
import com.springmvc.entity.ShoppingcartWithOther;
import com.springmvc.entity.User;
import com.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("")
public class OrderController {
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
    @Autowired
    private ManageOrder manageOrder;

    @RequestMapping(value = "/addorder",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView addorder(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("flow3");
        Order order;
        List<ShoppingcartWithOther> shoppingcartWithOthers=new LinkedList<ShoppingcartWithOther>();
        List<Shoppingcart> shoppingcartList;
        shoppingcartList=manageShoppingcart.listShoppingcart(userid);
        for (Shoppingcart s:shoppingcartList) {
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            ShoppingcartWithOther other=new ShoppingcartWithOther(s,manageShopping.selectShopByid(s.getShoppingid()),manageComputer.selectComputerByid(s.getShoppingid()));
            order=new Order();
            order.setConsignee(manageAddress.getAddressByid(userid).getConsignee());
            order.setOrdername(other.getComputer().getImgurl());
            order.setTrading(other.getShoppingcart().getTrading());
            order.setOrderuser(userid);
            order.setOrdertime(date);
            order.setOrderstate("交易完成");
//            manageOrder.addOrder(order);
//            if(manageOrder.addOrder(order).equals("添加成功")){
//                mav.setViewName("test");
//                return mav;
//            }
//            manageShoppingcart.deleteShoppingcart(s.getPrimarykey());
        }
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping(value = "/findorder",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView findorder(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("");
        return mav;
    }
}
