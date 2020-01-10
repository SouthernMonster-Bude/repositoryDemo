package com.hjm.annotation.demo.test;

import com.hjm.annotation.demo.MyAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo {

    public static void main(String[] args) throws Exception {
        //获取类上的注解
        Class<TestAnno> clazz = TestAnno.class;
        MyAnnotation myAnnotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotationOnClass.getValue());

        Field field = clazz.getDeclaredField("name");
        MyAnnotation myAnnotationOnField = field.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotationOnField.getValue());

        Method method = clazz.getMethod("setName",String.class);
        MyAnnotation myAnnotationOnmethod = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotationOnmethod.getValue());
        Method method2 = clazz.getMethod("getName2",null);
        MyAnnotation myAnnotationOnmethod2 = method2.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotationOnmethod2.getValue());
    }
}
