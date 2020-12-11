package com.hjm.boot;

import com.hjm.boot.pojo.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Houjiemu
 * @create 2020-11-03 14:29
 * 
 */

/**
 * springboot 单元测试
 * 可以在测试期间很方便的类似编码一样
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestApplication {
    @Autowired
    People person;
    @Test
    public void contexrLoad(){
        System.out.println(person);
    }
}
