package com.springboot.test.springbootdemo.blackmagic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootdemo
 * @description: 你好控制器
 * @author: Fuwen
 * @create: 2021-09-06 22:48
 **/
@RestController
public class HelloController {
    @Autowired
    private UserProperties userProperties;
    @RequestMapping(value = "/hello", method = {RequestMethod.GET,RequestMethod.POST})
    public String say(){
        return userProperties.getInfo();
    }

    @RequestMapping(value = "getUser",method = {RequestMethod.GET})
    public UserProperties getUserProperties(){
        UserProperties userProperties = new UserProperties();
        userProperties.setAge(18);
        userProperties.setNickName("谭富文");
        return userProperties;
    }
}
