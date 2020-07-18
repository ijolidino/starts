package com.blackmagic.ssm.dao;

import com.blackmagic.ssm.domain.Member;
import com.blackmagic.ssm.domain.Orders;
import com.blackmagic.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

            @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.blackmagic.ssm.dao.IProductDao.findById"))})
@Select("select * from orders")
    List<Orders> findAll() throws Exception;
@Select("select * from orders where id=#{ordersId}")
@Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "orderNum", column = "orderNum"),
        @Result(property = "orderTime", column = "orderTime"),
        @Result(property = "peopleCount", column = "peopleCount"),
        @Result(property = "orderDesc", column = "orderDesc"),
        @Result(property = "payType", column = "payType"),
        @Result(property = "orderStatus", column = "orderStatus"),
        @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.blackmagic.ssm.dao.IProductDao.findById")),
        @Result(property = "member",column = "memberId",javaType = Member.class,one=@One(select = "com.blackmagic.ssm.dao.IMemberDao.findById")),
        @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.blackmagic.ssm.dao.ITravellerDao.findByOrdersId"))})
    Orders findById(String orderId) throws Exception;

}
