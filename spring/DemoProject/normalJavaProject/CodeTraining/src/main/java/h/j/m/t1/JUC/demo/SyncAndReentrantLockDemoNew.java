package h.j.m.t1.JUC.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 题目：多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * 。。。。。
 * 打印10轮
 * */
public class SyncAndReentrantLockDemoNew {
    public static void main(String[] args) {
        ShareRsc shareRsc =new ShareRsc();
        new Thread(()->{
            shareRsc.print5(1,"B");
            System.out.println("*******************"+Thread.currentThread().getName()+" mission done！");
        },"A").start();
        new Thread(()->{
            shareRsc.print5(2,"C");
            System.out.println("*******************"+Thread.currentThread().getName()+" mission done！");
        },"B").start();
        new Thread(()->{
            shareRsc.print5(3,"A");
            System.out.println("*******************"+Thread.currentThread().getName()+" mission done！");
        },"C").start();
    }

}
class ShareRsc{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Map<String,Condition> conditionMap = new HashMap<String,Condition>();
    {
        conditionMap.put("cA",lock.newCondition());
        conditionMap.put("cB",lock.newCondition());
        conditionMap.put("cC",lock.newCondition());
    }

    /**
     *
     * @param flag (1:A,2:B,3:C)
     * @param next (A->B->C->A)
     * @throws InterruptedException
     */
    public void print5(int flag,String next)  {
        lock.lock();

        try {
            while (number!=flag){
                conditionAwait(Thread.currentThread().getName());
            }
            // BEGIN WORK
            if(flag==1){
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+"'s Task is print "+flag + " "+i);
                }
            }else if(flag==2){
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName()+"'s Task is print "+flag + " "+i);
                }
            }else {
                for (int i = 0; i < 7; i++) {
                    System.out.println(Thread.currentThread().getName()+"'s Task is print "+flag + " "+i);
                }
            }
            number = flag +1;
            // END WORK
            conditionNotifiy(next);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void conditionAwait(String id) throws InterruptedException {
        conditionMap.get("c"+id).await();
    }
    public void conditionNotifiy(String id) throws InterruptedException {
        conditionMap.get("c"+id).signal();
    }

}
