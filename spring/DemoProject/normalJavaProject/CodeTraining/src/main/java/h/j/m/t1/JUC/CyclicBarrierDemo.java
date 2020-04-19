package h.j.m.t1.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
*
* */
public class CyclicBarrierDemo {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{System.out.println("召唤神龙");});

        for(int i=1;i<=7;i++){
            final int tempInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到第："+tempInt+"龙珠");
                try{
                    TimeUnit.MILLISECONDS.sleep((long)(1000*tempInt));
                    System.out.println(Thread.currentThread().getName()+"龙珠归位");
                    cyclicBarrier.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } catch (BrokenBarrierException e){
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
