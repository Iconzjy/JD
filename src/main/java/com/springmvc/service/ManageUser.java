package com.springmvc.service;

import com.springmvc.entity.Address;
import com.springmvc.entity.User;

public interface ManageUser {

    //用于用户注册
    String registUser(User user);

    //用于删除用户
    String deleteUser(int id);

    //用于修改用户信息，包括地址表中的相关信息
    String updataUser(int id, User user,Address address);

    //用于用户登录
    boolean login(int id, String pwd);

    //判断用户是否存在
    boolean isExit(int id);

    //用于返回用户
    User getUser(int id);
}
