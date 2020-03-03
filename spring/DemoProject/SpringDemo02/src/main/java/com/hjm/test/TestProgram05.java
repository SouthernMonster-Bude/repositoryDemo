package com.hjm.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/***
 * 1.统计一个数字字符在一个整数数值范围内部出现的次数
 * 2.返回第n个丑数 丑数是素因子只为2,3,5
 */
public class TestProgram05 {

    @Test
    public void test01() {
        run();
    }
    public static void run(){
        countNumTimes(1000,0);
    }
    public static void countNumTimes(int n,int num){
        char charN = (num+"").charAt(0);
        int count = 0;
        for(int i=0;i<=n;i++){
            String iStr = i+"";
            for(int k=0;k<iStr.length(); k++){
                if(charN==iStr.charAt(k)){
                    count ++;
                    System.out.print(iStr+"\t");
                }
            }
        }
        System.out.println("统计"+charN+"在数值范围[0~"+n+"]中出现的次数为"+count);

    }
    @Test
    public void run02(){
        generateUglinessNum(20);
    }
    public static int generateUglinessNum(int n){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i=1;i<n;i++){
            int num2 = list.get(x)*2;
            int num3 = list.get(y)*3;
            int num5 = list.get(z)*5;
            int temp = Math.min(Math.min(num2,num3),num5);
            if(temp==num2) x++;
            if(temp==num3) y++;
            if(temp==num5) z++;
            list.add(temp);
        }
        for (Integer i:list){
            System.out.print(i+"\t");
        }
        return list.get(list.size()-1);
    }



}
