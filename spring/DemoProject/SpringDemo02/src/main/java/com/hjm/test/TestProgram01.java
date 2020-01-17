package com.hjm.test;

import java.util.Scanner;

public class TestProgram01 {
    static int B,H;
    static boolean flag = false;
    static{
        Scanner in = new Scanner(System.in);
        B=in.nextInt();
        in.nextLine();
        H=in.nextInt();
        flag = B>0&&H>0;
        in.close();
        if(!flag){
            throw new RuntimeException("Breadth and height must be positive");
        }
    }
    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }
    }//end of main
}
