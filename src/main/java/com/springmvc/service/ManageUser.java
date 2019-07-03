package com.springmvc.service;

import com.springmvc.entity.Address;
import com.springmvc.entity.User;

public interface ManageUser {

    //用于用户注册
    String registUser(User user) throws Exception;

    //用于删除用户
    String deleteUser(int id) throws Exception;

    //用于修改用户信息，包括地址表中的相关信息
    String updataUser(int id, User user,Address address) throws Exception;

    //用于用户登录
    boolean login(int id, String pwd) throws Exception;
}
