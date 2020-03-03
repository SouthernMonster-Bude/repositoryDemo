package com.hjm.test;

import o.test.MySuperUtils;
import org.junit.Test;


/***
 * 1.给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 * 如果这个数被3整除，打印fizz.
 * 被5整除，打印buzz.
 * 能同时被3和5整除，打印fizz buzz.
 * 既不能被 3 整除也不能被 5 整除，打印数字本身。
 * 一个if实现
 */
public class TestProgram07 {

    @Test
    public void test02(){
        String strChars = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMwqertyuiopasdfghjklzxcvbnm=+_";
        String target = "kPH+bIxk5D2deZiIxcaaaA==";
        String out = "";
        for (int i=0;i<target.length();i++){
            out+=strChars.charAt((int)(Math.random()*strChars.length()));
        }
        System.out.println(target.length());
        System.out.println(out.length());
        System.out.println("MzQ1Njc4OTA5MDkwOTA5MA==".length());
        System.out.println(out);
    }
    @Test
    public void test01(){
        int n=2001;
        for(int i=1;i<=n;i++){
            String str = "";
            if(i%3==0){
                str = i%5==0?"fizz+buzz, ":"fizz, ";
            }else{
                str = i%5==0?"buzz, ":i+", ";
            }
            System.out.print(str);
            if(i%5==0){
                System.out.println();
            }
        }
    }
}
