package com.hjm.test;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.*;

public class TestProgram03 {



//改良版
    @Test
    public void test02() {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "Goodbye bye bye world world world";
        Matcher m = p.matcher(input);
        List<String> sList = new ArrayList<String>();
        while(m.find()){
            input = input.replaceAll(m.group(),m.group(1));
            System.out.println(m.group());
        }
        System.out.println("Out: " + input);
    }
    @Test
    public void test01() {
        String regex = "\\w+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "Goodbye bye bye world world world";
        Matcher m = p.matcher(input);
        List<String> sList = new ArrayList<String>();
        while(m.find()){
            String strs = m.group();
            if(sList.indexOf(strs.toLowerCase())>-1){
                input = input.replaceFirst("(?<!\\w)"+strs+"(?!\\w)\\s*","");
            }else{
                sList.add(strs.toLowerCase());
            }
            System.out.println(m.group());
        }
        System.out.println("Out: " + input);
    }
    @Test
    public void test() {
        double payment = 998763.999;

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        String s = nf.format(payment);
        String us = "$"+s;
        String india = "Rs."+s;
        String china = "￥"+s;
        String france = s.replace(","," ").replace(".",",")+" €";
        System.out.println("XX: " + nf.format(payment));
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
    @Test
    public void test04() {
        String regex = "UUID:\\w+;";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "jkhhjk;jkl;UUID:;kjnjkdnf;";
        Matcher m = p.matcher(input);
        while(m.find()){
            String strs = m.group();
            System.out.println(m.group());
        }
        System.out.println("Out: " + input);
    }

}
