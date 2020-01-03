package com.y;

import com.hjm.test.controller.UserController;
import com.hjm.test.dto.User;
import com.hjm.test.service.UserService;
import com.hjm.test.service.auto.UserService01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/spring/sping.xml");
        UserService u = (UserService)ac.getBean("userService007");
        System.out.println("获取到的userService007："+u);

    }
    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/spring/sping.xml");
        UserController controller = (UserController)ac.getBean("userController");
        System.out.println(controller.hello());
//        UserService01 userService01 = (UserService01)ac.getBean("userSvc");
//        System.out.println(userService01.random());
        // User u = (User)ac.getBean("factory01User005");

    }
    @Test
    public void test01() {
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
