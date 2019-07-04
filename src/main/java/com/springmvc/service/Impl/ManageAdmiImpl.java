package com.springmvc.service.Impl;

import com.springmvc.dao.AdministratorMapper;
import com.springmvc.entity.Administrator;
import com.springmvc.service.ManageAdmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ManageAdmiImpl implements ManageAdmi {

    @Autowired
    AdministratorMapper administratorMapper;
    @Override
    public boolean login(int id, String pwd) {
        if(administratorMapper.selectByPrimaryKey(id)==null)
            return false;
        return true;
    }

    @Override
    public Administrator getAdmi(int id) {
        return administratorMapper.selectByPrimaryKey(id);
    }
}
