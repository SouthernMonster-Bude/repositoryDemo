package h.j.m.t1.JUC.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//1.固定数量的线程池
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//2.单线程复用的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();//3.线程池容量可以动态扩张的线程池
        try {
            for (int i = 0; i < 1600; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
//                TimeUnit.MILLISECONDS.sleep(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
