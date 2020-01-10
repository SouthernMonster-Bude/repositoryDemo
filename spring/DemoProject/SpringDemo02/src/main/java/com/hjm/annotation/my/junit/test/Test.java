package com.hjm.annotation.my.junit.test;

import com.hjm.annotation.my.junit.MyAfter;
import com.hjm.annotation.my.junit.MyBefore;
import com.hjm.annotation.my.junit.MyTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        //实例化MyJunitTest
        Class<MyJunitTest> clazz = MyJunitTest.class;
        Object instance = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        List<Method> preTestMethodList = new ArrayList<Method>();
        List<Method> testMethodList = new ArrayList<Method>();
        List<Method> postTestMethodList = new ArrayList<Method>();

        for(Method m : methods){
            if(m.isAnnotationPresent(MyBefore.class)){
                preTestMethodList.add(m);
            }else if(m.isAnnotationPresent(MyAfter.class)){
                postTestMethodList.add(m);
            }else if(m.isAnnotationPresent(MyTest.class)){
                testMethodList.add(m);
            }
        }

        for (Method m : testMethodList){
            System.out.println("============执行["+m.getName()+"] Begin==============");
            for (Method pre_m : preTestMethodList){
                pre_m.invoke(instance);
            }
            m.invoke(instance);
            for (Method post_m : postTestMethodList){
                post_m.invoke(instance);
            }
            System.out.println("============执行["+m.getName()+"] END==============");
        }
    }
}
