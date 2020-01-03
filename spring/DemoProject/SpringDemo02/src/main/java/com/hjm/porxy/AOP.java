package com.hjm.porxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect//指定为切面类
public class AOP {
    //里面的值为切入点表达式
    @Before("execution(* com.hjm.mod.*.*.*.*(..))")
    public void begin() {
        System.out.println("开始事务");
    }
    @After("execution(* com.hjm.mod.*.*.*.*(..))")
    public void close() {
        System.out.println("关闭事务");
    }
}