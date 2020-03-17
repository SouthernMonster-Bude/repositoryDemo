package com.hjm.webdemo;

import com.hjm.webdemo.interceptor.PathUrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //添加自定义拦截器


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PathUrlInterceptor()).addPathPatterns("/**");
    }
}
