package com.springmvc.service.Impl;

import com.springmvc.dao.AddressMapper;
import com.springmvc.dao.UserMapper;
import com.springmvc.entity.Address;
import com.springmvc.entity.User;
import com.springmvc.service.ManageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManageUserImpl implements ManageUser {

    @Autowired
    UserMapper userMapper;
    AddressMapper addressMapper;

    @Override
    public String registUser(User user) throws Exception {
        try {
            userMapper.insertSelective(user);
            return "注册成功";
        }catch (Exception e){
            return "注册失败,用户id已经存在";
        }finally {

        }
    }

    @Override
    public String deleteUser(int id) throws Exception {
        try {
            userMapper.deleteByPrimaryKey(id);
            return "注销成功";
        }catch (Exception e){
            return "注销失败";
        }finally {

        }
    }

    @Override
    public String updataUser(int id, User user,Address address) throws Exception {
        try {
            userMapper.updateByPrimaryKeySelective(user);
            addressMapper.updateByPrimaryKeySelective(address);
            return "修改成功";
        }catch (Exception e){
            String message;

            return "修改失败";
        }finally {

        }
    }

    @Override
    public boolean login(int id, String pwd) throws Exception {
        if(userMapper.selectByPrimaryKey(id).getPwd().equals(pwd)){
            return true;
        }else {
            return false;
        }
    }
}
