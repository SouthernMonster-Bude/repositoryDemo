package com.hjm.boot.config;

import com.hjm.boot.pojo.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Houjiemu
 * @create 2020-11-03 15:42
 */
@Configuration // 指定当前类是一个配置类
public class MyConfig {
    @Bean
    public People peo(){
        return new People();
    }
}
