package com.hjm.test;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestProgram03 {




    @Test
    public void test01() {
        String regex = "\\w+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "I love Love to To tO code";
//        String input = "Goodbye bye bye world world world";
        Matcher m = p.matcher(input);
//        while (m.find()) {
//            input = input.replaceAll("to","");
//        }
        List<String> sList = new ArrayList<String>();
        while(m.find()){
            String strs = m.group();
            if(sList.indexOf(strs.toLowerCase())>-1){
                //(?<=#).*?(?=</td>)
                input = input.replaceAll("(?<!\\w)"+strs+"(?!\\w)\\s*","");
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
}
