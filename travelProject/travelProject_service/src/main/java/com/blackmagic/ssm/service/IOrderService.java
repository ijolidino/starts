package com.blackmagic.ssm.service;

import com.blackmagic.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {

    Orders findById(String orderId) throws Exception;

    List<Orders> findAll(Integer pageNum, Integer pageSize) throws Exception;


}
