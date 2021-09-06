package com.springboot.test.springbootdemo.blackmagic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springbootdemo
 * @description: 用户
 * @author: Fuwen
 * @create: 2021-09-06 23:09
 **/
@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private String nickName;

    private Integer age;

    private String info;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
