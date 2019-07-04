package com.springmvc.service;

import com.springmvc.entity.Administrator;

public interface ManageAdmi {
    //用于管理员登录
    boolean login(int id, String pwd);

    //获取管理员信息
    Administrator getAdmi(int id);
}
