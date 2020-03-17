package com.hjm.interfaceSegregation;

public class Segregation {
}


//
interface Interface0{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
}
class B implements Interface0{

    @Override
    public void operation1() {
        System.out.println("B operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B operation4");
    }
}
class D implements Interface0{

    @Override
    public void operation1() {
        System.out.println("D operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D operation4");
    }
}

class A{
    public void opt1(B b){
        b.operation1();
    }
    public void opt2(B b){
        b.operation2();
    }
    public void opt3(B b){
        b.operation3();
    }
}
class C{
    public void opt1(D c){
        c.operation1();
    }
    public void opt2(D c){
        c.operation4();
    }
    public void opt3(D c){
        c.operation3();
    }
}