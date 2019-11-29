package com.hjm.test.test;

import com.hjm.test.dto.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

    public static void main(String[] args) {
        /**
         * 1 通过Resource获取BeanFactory
         * 加载Spring配置文件
         * 通过XmlBeanFactory+配置文件来创建IOC容器
         */
//        //加载Spring的资源文件
//        Resource resource = new ClassPathResource("config/spring/sping.xml");
//
//        //创建IOC容器对象【IOC容器=工厂类+applicationContext.xml】
//        BeanFactory beanFactory = new XmlBeanFactory(resource);

        /**
         * 2 类路径下XML获取ApplicationContext
         * 直接通过ClassPathXmlApplicationContext对象来获取
         */
        // 得到IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/spring/sping.xml");

        User u = (User)ac.getBean("user003");
        System.out.println(u);
        User u2 = (User)ac.getBean("user004");
        System.out.println(u2.getId()+" -- "+u2.getUsername());


    }
}
