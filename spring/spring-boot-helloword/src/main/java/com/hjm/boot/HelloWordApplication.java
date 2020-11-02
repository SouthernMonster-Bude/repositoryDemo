package com.hjm.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Houjiemu
 * @create 2020-11-02 14:11
 */
@SpringBootApplication// 此注解说明这是一个springboot应用
public class HelloWordApplication {
    public static void main(String[] args) {
        // 将spring应用启动起来
        SpringApplication.run(HelloWordApplication.class,args);
    }
}
