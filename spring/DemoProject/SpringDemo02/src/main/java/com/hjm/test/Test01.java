package com.hjm.test;

import com.hjm.mod.user.dao.IUserDao;
import com.hjm.mod.user.dao.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring/proxy.conf.xml");
        //这里得到的是代理对象....
        IUserDao iUser = (IUserDao) ac.getBean("userDao");
        System.out.println(iUser.getClass());
        iUser.save();
        //没有接口的对象代理测试
        OrderDao odd = (OrderDao) ac.getBean("orderDao");
        System.out.println(odd.getClass());
        odd.save();
    }
}
