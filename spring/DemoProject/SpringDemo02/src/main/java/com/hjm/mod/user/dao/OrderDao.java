package com.hjm.mod.user.dao;
import org.springframework.stereotype.Component;
@Component
public class OrderDao {
    @Deprecated
    public void save() {
        System.out.println("我已经进货了！！！");
    }
}