package com.hjm.liskovSubstitution;

public class LiskovSubstitution {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        System.out.println( a.add(1,3));
        System.out.println( b.add(1,3));

    }
}

//class A {
//    public int add(int a,int b){
//        return a+b;
//    }
//}
//class B extends A{
//    public int add(int a,int b){
//        return a-b;
//    }
//    public int add2(int a,int b){
//        return a+b;
//    }
//}

class Base{}

class A extends Base {
    public int add(int a,int b){
        return a+b;
    }
}
class B extends Base {
    public int add(int a,int b){
        return a-b;
    }
    public int add2(int a,int b){
        return a+b;
    }
}