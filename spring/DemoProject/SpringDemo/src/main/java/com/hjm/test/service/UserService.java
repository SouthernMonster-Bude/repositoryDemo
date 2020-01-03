package com.hjm.test.service;

import com.hjm.test.dto.User;

import java.util.List;

public class UserService {

    User user;
    User user02;

    List<String> userList;
    public UserService(User user){
        System.out.println("UserService(User user) "+this+" created!");
        this.user = user;
    }
    UserService(User user,List<String> userList){
        System.out.println("UserService(User user,List<String> userList) "+this+" created!");
        this.user = user;
        this.userList = userList;
    }

    public User getUser02() {
        return user02;
    }

    public void setUser02(User user02) {
        System.out.println("setUser02注入UserService user02：" +user02);
        this.user02 = user02;
    }

}
