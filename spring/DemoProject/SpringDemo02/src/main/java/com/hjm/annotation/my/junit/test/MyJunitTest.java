package com.hjm.annotation.my.junit.test;

import com.hjm.annotation.my.junit.MyAfter;
import com.hjm.annotation.my.junit.MyBefore;
import com.hjm.annotation.my.junit.MyTest;
import o.test.MethodInfos;

public class MyJunitTest {
    @MyAfter
    public void after1(){
        System.out.println("MyJunitTest after1");
    }
    @MyAfter
    public void after2(){
        System.out.println("MyJunitTest after2");
    }
    @MyTest
    public void test(){
        System.out.println("MyJunitTest test");
        MethodInfos.getCurrentMethodsInfos();
    }
    @MyTest
    public void test2(){
        MethodInfos.getCurrentMethodsInfos();
    }

    @MyBefore
    public void before1(){
        System.out.println("MyJunitTest before1");
    }
    @MyBefore
    public void before2(){
        System.out.println("MyJunitTest before2");
    }
}
