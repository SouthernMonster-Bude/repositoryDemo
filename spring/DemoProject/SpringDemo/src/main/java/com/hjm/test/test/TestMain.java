package com.hjm.test.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {

    public static void main(String[] args) {
//        String diverse = "MA;IMEA:aaa;DEVICEID:eee;MPN:bbb;MAC:ccc;@GTJA|Vddd";
        String diverse = "MI;UUID:aaa;MPN:bbb;MAC:ccc;@GTJA|Vddd";
//        String[] infos = diverse.split(";");
//        for(String info : infos){
//            if(info.indexOf(":")>-1){
//                System.out.println(info.split(":")[0]+"  >>>  "+info.split(":")[1]);
//            }else{
//                System.out.println(info);
//            }
//        }

//        String testString = "java怎么利用正则表达式从给定的字符串中取出匹配规则字符串";
//        String testString = "MI;UUID:aaa;MPN:bbb;MAC:ccc;@GTJA|Vddd";
//        Pattern pattern = Pattern.compile("UUID:\\w+");
        String testString = "MA;IMEA:aaa;DEVICEID:eee;MPN:bbb;MAC:ccc;@GTJA|Vddd";
        Pattern pattern = Pattern.compile("IMEA:\\w+");
        Matcher matcher = pattern.matcher(testString);
        matcher.find();
        System.out.println(matcher.group());
    }
}
