package com.springmvc.dao;

import com.springmvc.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}