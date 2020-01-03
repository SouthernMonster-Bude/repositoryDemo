package com.y.proxy;

import com.hjm.proxy.ProxyFactory;
import com.hjm.test.controller.UserController;
import com.hjm.test.dao.IUserDao;
import com.hjm.test.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {
    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/spring/proxy.conf.xml");
        IUserDao userDaoProxy = (IUserDao)ac.getBean("userDaoProxy");
        userDaoProxy.random();
    }
    @Test
    public void test01(){

        UserDao userDao = new UserDao();

        UserDao factory = (UserDao) new ProxyFactory(userDao).getProxyInstance();

        factory.random();
    }
}
