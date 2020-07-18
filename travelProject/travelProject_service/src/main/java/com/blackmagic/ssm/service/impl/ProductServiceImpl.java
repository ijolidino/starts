package com.blackmagic.ssm.service.impl;

import com.blackmagic.ssm.service.IProductService;
import com.blackmagic.ssm.dao.IProductDao;
import com.blackmagic.ssm.domain.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

//    public void setProductDao(IProductDao iProductDao){
//        this.productDao=productDao;
//    }

}
