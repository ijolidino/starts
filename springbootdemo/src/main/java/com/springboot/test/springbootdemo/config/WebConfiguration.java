package com.springboot.test.springbootdemo.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springbootdemo
 * @description: 设置配置
 * @author: Fuwen
 * @create: 2021-09-06 23:29
 **/
@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
}
