package com.blackmagic.ssm.service.impl;

import com.blackmagic.ssm.dao.IOrderDao;
import com.blackmagic.ssm.domain.Orders;
import com.blackmagic.ssm.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public Orders findById(String orderId) throws Exception {
        return orderDao.findById(orderId);
    }

    @Override
    
    public List<Orders> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }


}
