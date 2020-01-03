package com.hjm.test.factory;

import com.hjm.test.dto.User;

public class Factory01 {

    public static User getUserBean(){
        System.out.println("Factory01 static Method getUserBean>>");
        return new User();
    }
    public User getUserBean02(){
        System.out.println("Factory01 non-static Method getUserBean02>>");
        return new User();
    }
}
