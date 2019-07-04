package com.springmvc.controller;


import com.springmvc.entity.User;
import com.springmvc.service.ManageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private ManageUser manageUser;
    User myuser = new User();

    @RequestMapping(value = "/firtPage")
    public ModelAndView firstpage(){
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView("test");
        return mav;
    }

    @RequestMapping(value = "/denglu")
    public ModelAndView denglu(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    @RequestMapping(value = "/zhuce")
    public ModelAndView zhuce(){
        ModelAndView mav = new ModelAndView("regist");
        return mav;
    }

    @RequestMapping(value = "/userlogin",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView login(String id, String pwd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView("index");
        id = request.getParameter("userName");
        pwd = request.getParameter("password");
        boolean b=manageUser.login(Integer.parseInt(id),pwd);
        if(b){
            //登录成功
            myuser=manageUser.getUser(Integer.parseInt(id));
            mav.addObject("user",myuser);
            return mav;
        }

        else {
            PrintWriter out;
            out=response.getWriter();
            out.print("<script>alert('login failed');window.location.href='denglu';</script>");
            out.close();
            mav.setViewName("login");
            return mav;
        }
    }


    @RequestMapping(value = "/userregist",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        String id = request.getParameter("zhanghao");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String checkcode = request.getParameter("checkcode");
        if(!checkcode.equals("3EHM")){
            //验证码错误页面
            PrintWriter out;
            out=response.getWriter();
            out.print("<script>alert('identifying code error');window.location.href='zhuce';</script>");
            out.close();
            mav.setViewName("regist");
            return mav;
        }
        if(!password.equals(password1)){
            //密码不一样
            PrintWriter out;
            out=response.getWriter();
            out.print("<script>alert('password mismatch');window.location.href='zhuce';</script>");
            out.close();
            mav.setViewName("regist");
            return mav;
        }
        if(manageUser.isExit(Integer.parseInt(id))){
            //帐号已经存在
            PrintWriter out;
            out=response.getWriter();
            out.print("<script>alert('id is exist');window.location.href='zhuce';</script>");
            out.close();
            mav.setViewName("regist");
            return mav;
        }
        User user = new User();
        user.setName(username);
        user.setId(Integer.parseInt(id));
        user.setPwd(password);
        manageUser.registUser(user);
        PrintWriter out;
        out=response.getWriter();
        out.print("<script>alert('success');window.location.href='firtPage';</script>");
        out.close();
        mav.setViewName("test");
        return mav;
    }
}
