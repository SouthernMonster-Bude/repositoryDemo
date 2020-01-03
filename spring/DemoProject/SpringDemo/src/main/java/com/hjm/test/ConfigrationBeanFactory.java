package com.hjm.test;

import com.hjm.test.dto.User;
import com.hjm.test.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigrationBeanFactory {
    @Bean
    public UserService userService007(){
        UserService u = new UserService(new User());
        System.out.println("这是ConfigrationBeanFactory创建的userService:"+u);
        return u;
    }
}
