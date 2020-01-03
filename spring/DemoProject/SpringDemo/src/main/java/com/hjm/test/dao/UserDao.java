package com.hjm.test.dao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{
    public double random() {
        double rand = Math.random();
        System.out.println("rand: "+rand);
        return rand;
    }
}
