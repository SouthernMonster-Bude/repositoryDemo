package com.hjm.test;

import o.test.MethodInfos;
import o.test.MySuperUtils;
import o.test.TestClassName;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class TestAlgorithm {


    //模拟随机放置地雷
    @Test
    public void shuffleTest03(){
        long t1 = System.currentTimeMillis();
        long t2 = 0L;
        String[] cards = new  String[100];
        for (int i = 0; i <cards.length ; i++){
            cards[i]="B";
        }
        String[] zeros = new String[500];
        for (int i = 0; i <zeros.length ; i++){
            zeros[i]="0";
        }
        cards = MySuperUtils.cancat(cards,zeros,String.class);
        t2 = System.currentTimeMillis()-t1;
        System.out.println(t2+"ms执行完毕");
        for(int i =cards.length-1 ; i>=0 ; i--){
            int randIndx = (int)(Math.random()*i);
            String temp = cards[i];
            cards[i] = cards[randIndx];
            cards[randIndx] = temp;
        }
        t2 = System.currentTimeMillis()-t1;
        System.out.println(t2+"ms执行完毕");
        for(int i=0 ;i< cards.length;i++){
            if(cards[i].equals("B"))
                System.out.print(cards[i]+"\t");
            else
                System.out.print(cards[i]+"\t");
            if(i%20==19){
                System.out.println();
            }
        }
        System.out.println();
        MethodInfos.getCurrentMethodsInfos();
        System.out.println((System.currentTimeMillis()-t1)+"ms执行完毕");
    }
    @Test
    public void shuffleTest02(){
        long t1 = System.currentTimeMillis();
        long t2 = 0L;
        int[] cards = new  int[5500000];
        for (int i = 0; i <cards.length ; i++){
            cards[i]=i;
        }
        t2 = System.currentTimeMillis()-t1;
        System.out.println(t2+"ms执行完毕");
        for(int i =cards.length-1 ; i>=0 ; i--){
            int randIndx = (int)(Math.random()*i);
            int temp = cards[i];
            cards[i] = cards[randIndx];
            cards[randIndx] = temp;
        }
        t2 = System.currentTimeMillis()-t1;
        System.out.println(t2+"ms执行完毕");
//        for(int i : cards){
//            System.out.print(i+"\t");
//        }
        System.out.println();
        MethodInfos.getCurrentMethodsInfos();
        System.out.println((System.currentTimeMillis()-t1)+"ms执行完毕");
        shuffleTest();
    }
    @Test
    public void shuffleTest(){
        long t1 = System.currentTimeMillis();
        long t2 = 0L;
        List<Integer> cards = new ArrayList<Integer>();
        for (int i = 1; i <5500000 ; i++){
            cards.add(i);
        }
        t2 = System.currentTimeMillis()-t1;
        System.out.println(t2+"ms执行完毕");
        cards.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.random()<0.5?1:-1;
            }
        });
        t2 = System.currentTimeMillis()-t1;
        System.out.println(t2+"ms执行完毕");
//        for(Integer i : cards){
//            System.out.print(i+"\t");
//        }
        System.out.println();
        MethodInfos.getCurrentMethodsInfos();
        System.out.println((System.currentTimeMillis()-t1)+"ms执行完毕");
    }

}
