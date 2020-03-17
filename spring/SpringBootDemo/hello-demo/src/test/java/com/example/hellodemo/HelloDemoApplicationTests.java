package com.example.hellodemo;

import com.example.hellodemo.pojo.Dog;
import com.example.hellodemo.pojo.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloDemoApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    People people;
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(people);
    }

}
