package com.springmvc.controller;


import com.springmvc.dao.ComputerMapper;
import com.springmvc.dao.ShopMapper;
import com.springmvc.dao.UserMapper;
import com.springmvc.entity.*;
import com.springmvc.service.ManageComputer;
import com.springmvc.service.ManageShopping;
import com.springmvc.service.ManageShoppingcart;
import com.springmvc.service.ManageUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("")
public class ShoppingController {

    @Autowired
    private ManageShopping manageShopping;
    @Autowired
    private ManageUser manageUser;
    @Autowired
    private ManageComputer manageComputer;
    @Autowired
    private ManageShoppingcart manageShoppingcart;


    @RequestMapping(value = "/searchshopping",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView searchShopping(HttpServletRequest request, HttpServletResponse response)throws IOException {
        ModelAndView mav = new ModelAndView("list");
        String shopping = request.getParameter("shoppingname");
        String userid = request.getParameter("user_id");
        User user=manageUser.getUser(Integer.parseInt(userid));
        List<Computer> computerList = manageComputer.getComputers(shopping);
        List<ShopCompute> shopComputeList=new LinkedList<>();
        for (Computer c: computerList) {
            Shop shop=manageShopping.selectShopByid(c.getId());
            ShopCompute shopCompute=new ShopCompute(shop,c);
            shopComputeList.add(shopCompute);
        }
        mav.addObject("user",user);
        mav.addObject("computer",shopComputeList);
        return mav;
    }

    @RequestMapping(value = "/getgoods",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getGoods(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("mygoods"));
        int userid=Integer.parseInt(request.getParameter("user_id"));
        ShopCompute shopCompute=new ShopCompute(manageShopping.selectShopByid(id),manageComputer.selectComputerByid(id));
        ModelAndView mav = new ModelAndView("goods");
        User user = manageUser.getUser(userid);
        mav.addObject("user",user);
        mav.addObject("shopcomputer",shopCompute);
        return mav;

    }

    //添加到购物车
    @RequestMapping(value = "/addgoods",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView addGoods(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("flow1");
        String price = request.getParameter("computerprice");
        String color = request.getParameter("color");
        String verion = request.getParameter("ver");
        String count = request.getParameter("amount");
        String beforshopcomputer = request.getParameter("beforshopcomputer");//获取数据库的id
        int beforshopcomputerid = Integer.parseInt(beforshopcomputer);
        double singleprice = manageShopping.selectShopByid(beforshopcomputerid).getPrice();
        double allprice = singleprice*Integer.parseInt(count);
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setUserid(userid);
        shoppingcart.setNumber(Integer.parseInt(count));
        shoppingcart.setFreight((double) 10);
        shoppingcart.setPrice((double) Double.parseDouble(price));
        shoppingcart.setAllprice(allprice);
        shoppingcart.setShoppingid(beforshopcomputerid);


//        if(str.equals("添加成功")){
//            mav.setViewName("test");
//            return mav;
//        }else{
//            return mav;
//        }
        List<ShoppingcartWithOther> shoppingcartWithOthers=new LinkedList<ShoppingcartWithOther>();
        List<Shoppingcart> shoppingcartList=new LinkedList<>();
        shoppingcartList=manageShoppingcart.listShoppingcart(userid);
        boolean isused=false;
        for(Shoppingcart s:shoppingcartList){
            if(s.getShoppingid().equals(shoppingcart.getShoppingid())){
                s.setNumber(shoppingcart.getNumber()+s.getNumber());
                manageShoppingcart.changeShoppingcart(s.getPrimarykey(),s.getNumber());
                isused=true;
            }
        }
        if (isused==false){
            String str=manageShoppingcart.addShoppingcart(shoppingcart);
        }
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

    //继续购物
    @RequestMapping(value = "/keepshpping",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView keepshpping(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("user_id"));
        User user = manageUser.getUser(userid);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user",user);
        return mav;
    }
}
