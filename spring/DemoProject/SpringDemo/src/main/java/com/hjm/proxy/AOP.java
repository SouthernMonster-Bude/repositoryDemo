package com.hjm.proxy;

import org.springframework.stereotype.Component;

@Component
public class AOP {

    public void begin() {
        System.out.println("开始事务");
    }

    public void close() {
        System.out.println("关闭事务");
    }
}