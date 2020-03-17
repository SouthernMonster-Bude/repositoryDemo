package com.hjm.interfaceSegregation;

/**
 * 客户端不应该依赖它不需要的接
 * 口，即一个类对另一个类的依赖
 * 应该建立在最小的接口上
 */
public class Segregation2 {
    public static void main(String[] args) {
// TODOAuto-generated method stub
// 使用一把
        A1 a = new A1();
        a.depend1(new B1()); //A1 类通过接口去依赖 B1 类
        a.depend2(new B1());
        a.depend3(new B1());
        C1 c = new C1();
        c.depend1(new D1()); // C1 类通过接口去依赖(使用)D1 类
        c.depend4(new D1());
        c.depend5(new D1());
    }
}
// 接口 1
interface Interface1 {
    void operation1();
}
// 接口 2
interface Interface2 {
    void operation2();
    void operation3();
}
// 接口 3
interface Interface3 {
    void operation4();
    void operation5();
}
class B1 implements Interface1, Interface2 {
    public void operation1() {
        System.out.println("B1 实现了 operation1");
    }
    public void operation2() {
        System.out.println("B1 实现了 operation2");
    }
    public void operation3() {
        System.out.println("B1 实现了 operation3");
    }
}
class D1 implements Interface1, Interface3 {
    public void operation1() {
        System.out.println("D1 实现了 operation1");
    }
    public void operation4() {
        System.out.println("D1 实现了 operation4");
    }
    public void operation5() {
        System.out.println("D1 实现了 operation5");
    }
}
class A1{ //A1 类通过接口 Interface1,Interface2 依赖(使用) B1 类，但是只会用到 1,2,3 方法
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend2(Interface2 i) {
        i.operation2();
    }
    public void depend3(Interface2 i) {
        i.operation3();
    }
}
class C1 { // C1 类通过接口 Interface1,Interface3 依赖(使用) D1 类，但是只会用到 1,4,5 方法
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend4(Interface3 i) {
        i.operation4();
    }
    public void depend5(Interface3 i) {
        i.operation5();
    }
}