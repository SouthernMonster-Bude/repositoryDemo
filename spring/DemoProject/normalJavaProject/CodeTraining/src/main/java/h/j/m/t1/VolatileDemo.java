package h.j.m.t1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
    /**
     * 1. volatile 可见性 volidate修饰的变量被修改会被及时的通知到其他线程
     *
     */
    public static void seeVolatileDemo(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
           System.out.println(Thread.currentThread().getName()+" --> start run");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.add60();
                System.out.println(Thread.currentThread().getName()+" --> update myData number to "+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"myThread").start();

        while (myData.number == 0){
            //main 线程等待myData中的number修改 但是其他线程对mydata number的修改对main线程不可见 没有通知动作

            // 一旦一个变量用volatile修饰 则这个变量被线程修改的操作就对其他线程来说就是可见的
        }

        System.out.println(Thread.currentThread().getName()+" --> mission done!");
    }
    /**
     * 2. 原子性 原子性是不可分割完整性 某个线程正在做某个业务时，中间不能加塞或者被分割。需要完整的执行结果。要么同时成功 要么同时失败
     * volitalie 不能保证原子性
     */
    public static void main(String[] args) {
        MyData myData = new MyData();
        for(int i=1;i<=20 ;i++){
            new Thread(()->{
                for(int j=1;j<=1000;j++){
                    myData.add10();
                    myData.atomicAdd();

                }
                System.out.println(Thread.currentThread().getName()+" --> update myData number to "+myData.number);
                System.out.println(Thread.currentThread().getName()+" --> update atomicInteger to "+myData.atomicInteger);
            },"Thread-"+i).start();
        }
        //main 需要等待上面20个线程执行完成志宏 mian看最终结果
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" --> mission done! number Result:"+myData.number);
        System.out.println(Thread.currentThread().getName()+" --> mission done! atomicInteger Result:"+myData.atomicInteger);
    }

}


class MyData{
//    int number = 0;
    // 改用volatile修饰
    volatile int number = 0;
    public void add60(){
        number +=60;
    }
    public void add10(){
        number +=10;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void atomicAdd(){
        atomicInteger.getAndIncrement();
    }

}