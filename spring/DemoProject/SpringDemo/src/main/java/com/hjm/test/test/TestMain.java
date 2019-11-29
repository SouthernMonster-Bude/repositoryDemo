package com.hjm.test.test;

public class TestMain {

    public static void main(String[] args) {
//        String diverse = "MA;IMEA:aaa;DEVICEID:eee;MPN:bbb;MAC:ccc;@GTJA|Vddd";
        String diverse = "MI;UUID:aaa;MPN:bbb;MAC:ccc;@GTJA|Vddd";
        String[] infos = diverse.split(";");
        for(String info : infos){
            if(info.indexOf(":")>-1){
                System.out.println(info.split(":")[0]+"  >>>  "+info.split(":")[1]);
            }else{
                System.out.println(info);
            }
        }
    }
}
