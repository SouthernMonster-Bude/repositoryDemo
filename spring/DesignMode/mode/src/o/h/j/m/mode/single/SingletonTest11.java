package o.h.j.m.mode.single;

public class SingletonTest11 {

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

}

//饿汉式 可能造成内存浪费
class Singleton11{
    private Singleton11(){}
    private final static Singleton11 instance = new Singleton11();
    public static Singleton11 getInstance(){
        return Singleton11.instance;
    }
}

class Singleton21{
    private Singleton21(){}
    private static Singleton21 instance;
    //静态代码块完成instance的创建 可能造成内存浪费
    static {
        instance = new Singleton21();
    }
    public static Singleton21 getInstance(){
        return Singleton21.instance;
    }
}