package com.yg.mapper;


import com.yg.domain.Order;

import java.util.List;

public interface OrderMapper {

    //查询全部的方法
    public List<Order> findAll();

}
