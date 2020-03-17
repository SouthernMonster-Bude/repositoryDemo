package o.h.j.m.mode.single;

public class SingletonTest11 {

    public static void main(String[] args) {
        Singleton31 instance = Singleton31.getInstance();
        Singleton31 instance1 = Singleton31.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

}

//懒汉式 此写法线程不安全的 只适用于单线程模式
class Singleton11 {
    private Singleton11() {
    }

    private static Singleton11 instance;

    public static Singleton11 getInstance() {
        if (null == instance) {
            System.out.println("Singleton11 instance");
            instance = new Singleton11();
        }
        return Singleton11.instance;
    }
}

//懒汉式 线程安全模式的写法 方法同步限制导致效率变低 大量使用getInstance的时候就会导致响应变缓慢
class Singleton21 {
    private Singleton21() {
    }

    private static Singleton21 instance;

    public static synchronized Singleton21 getInstance() {
        if (null == instance) {
            System.out.println("Singleton21 instance 线程安全");
            instance = new Singleton21();
        }
        return instance;
    }
}
//懒汉式 线程安全模式的写法 双重检查
class Singleton31 {
    private Singleton31() {
    }
//    volatile 修饰的变量 一旦被修改 就会立即被保存的内存中去
    private static volatile Singleton31 instance;

    public static Singleton31 getInstance() {
        if (null == instance) {
            System.out.println("Singleton31 instance 线程安全 第一重检查");
            synchronized(Singleton31.class){
                if (null == instance) {
                    System.out.println("Singleton31 instance 线程安全 第二重检查");
                    instance = new Singleton31();
                }
            }
        }
        return instance;
    }
}
//懒汉式 静态内部类 推荐使用
class Singleton41 {
    private Singleton41() {
    }
//    volatile 修饰的变量 一旦被修改 就会立即被保存的内存中去
    private static volatile Singleton41 instance;
    // 静态内部类不会随主类装载 只有当调用静态内部类的时候才会装载
    private static final class Singleton{
        private static volatile Singleton41 INSTANCE = new Singleton41();
    }
    public static Singleton41 getInstance() {

        return Singleton.INSTANCE;
    }
}
//枚举的方式单例模式 推荐使用 （由Effictive Java 作者推荐使用）
enum Singleton51{
    INSTANCE;
    public void sayOK(){
        System.out.println("enum Singleton51");
    }
}