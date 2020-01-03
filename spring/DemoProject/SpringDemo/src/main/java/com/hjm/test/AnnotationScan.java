package com.hjm.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//表该类是配置类
@Configuration
@ComponentScan("com.hjm.test.service.auto")
public class AnnotationScan {
}
