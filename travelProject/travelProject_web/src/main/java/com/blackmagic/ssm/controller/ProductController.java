package com.blackmagic.ssm.controller;

import com.blackmagic.ssm.domain.Product;
import com.blackmagic.ssm.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Product> products = productService.findAll();
//        mv.addObject("productList", products);
//        mv.setViewName("product-list");
//        return mv;
//    }
@RequestMapping("/findAll.do")
public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "6") Integer size) throws Exception{
    ModelAndView modelAndView = new ModelAndView();
    List<Product> ordersList = productService.findAll(page,size);
    PageInfo pageInfo = new PageInfo(ordersList);
    modelAndView.addObject("pageInfo",pageInfo);
    modelAndView.setViewName("product-list");
    return modelAndView;
}

//    public void setProductService(IProductService productService) {
//        this.productService = productService;
//    }
}
