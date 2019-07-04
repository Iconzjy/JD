package com.springmvc.controller;


import com.springmvc.entity.Administrator;
import com.springmvc.service.ManageAdmi;
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
public class AdmiController {
    @Autowired
    private ManageAdmi manageAdmi;
    private Administrator administrator;

    @RequestMapping(value = "/userlogin",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView login(String id, String pwd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView("test");
        id = request.getParameter("userName");
        pwd = request.getParameter("password");
        boolean b=manageAdmi.login(Integer.parseInt(id),pwd);
        if(b){
            //登录成功
            administrator=manageAdmi.getAdmi(Integer.parseInt(id));
            mav.addObject("admi",administrator);
            return mav;
        }

        else {
            PrintWriter out;
            out=response.getWriter();
            out.print("<script>alert('login failed');window.location.href='';</script>");
            out.close();
            mav.setViewName("");
            return mav;
        }
    }

}
