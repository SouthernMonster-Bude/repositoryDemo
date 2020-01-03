package com.hjm.test.controller;

import com.hjm.test.service.UserService;
import com.hjm.test.service.auto.UserService01;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource(name="userSvc")
    UserService01 userService;
    public String hello(){
        return "Hello,"+this+">>L:"+userService.random();
    }
}
