package com.blackmagic.ssm.controller;

import com.blackmagic.ssm.domain.Orders;
import com.blackmagic.ssm.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> ordersList = iOrderService.findAll();
//        modelAndView.addObject("orderlist",ordersList);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//    }
@RequestMapping("/findAll.do")
public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "6") Integer size) throws Exception{
    ModelAndView modelAndView = new ModelAndView();
    List<Orders> ordersList = iOrderService.findAll(page,size);
    PageInfo pageInfo = new PageInfo(ordersList);
    modelAndView.addObject("pageInfo",pageInfo);
    modelAndView.setViewName("orders-list");
    return modelAndView;
}
@RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId) throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    Orders orders=iOrderService.findById(orderId);
    modelAndView.addObject("orders",orders);
    modelAndView.setViewName("orders-show");
    return modelAndView;
}
}
