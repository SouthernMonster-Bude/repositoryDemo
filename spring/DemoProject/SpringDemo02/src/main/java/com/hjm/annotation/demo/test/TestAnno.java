package com.hjm.annotation.demo.test;

import com.hjm.annotation.demo.MyAnnotation;
@MyAnnotation(getValue = "annotation is TestAnno")
public class TestAnno {
    @MyAnnotation(getValue = "annotation is name")
    String name;
    @MyAnnotation(getValue = "annotation is setName")
    public void setName(String name) {
        this.name = name;
    }
    @MyAnnotation(getValue = "annotation is getName")
    public String getName() {
        return name;
    }
    @MyAnnotation()
    public String getName2() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(new TestAnno().getName());
    }
}
