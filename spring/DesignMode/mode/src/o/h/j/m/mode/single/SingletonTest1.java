package o.h.j.m.mode.single;

public class SingletonTest1 {

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

}
//饿汉式 可能造成内存浪费
class Singleton1{
    private Singleton1(){}
    private final static Singleton1 instance = new Singleton1();
    public static Singleton1 getInstance(){
        return Singleton1.instance;
    }
}
class Singleton2{
    private Singleton2(){}
    private static Singleton2 instance;
    //静态代码块完成instance的创建 可能造成内存浪费
    static {
        instance = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return Singleton2.instance;
    }
}