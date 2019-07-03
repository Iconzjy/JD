package com.springmvc.service.Impl;

import com.springmvc.dao.OrderMapper;
import com.springmvc.entity.Order;
import com.springmvc.service.ManageOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManageOrderImpl implements ManageOrder {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public String addOrder(Order order) throws Exception{
        try{
            orderMapper.insertSelective(order);
            return "添加成功";
        }catch (Exception e){
            return "添加失败";
        }finally {

        }
    }

    @Override
    public String deleteOrder(int orderid)throws Exception{
        try{
            orderMapper.deleteByPrimaryKey(orderid);
            return "删除成功";
        }catch (Exception e){
            return "删除失败，未存在这项订单";
        }finally {

        }
    }
}
