package com.hjm.test;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * 完成 骰子点数随机的测试
 * 和 不使用+计算两个数的和
 */
public class TestProgram04 {

    @Test
    public void test01() {
        run();
//        List<int[]> list = spiltNum(9,3);
//        for(int[] resi:list){
//            for(int k=0 ; k<resi.length;k++){
//                System.out.print(resi[k]+" ");
//            }
//            System.out.println();
//        }
    }
    public static double run(){
        int[] diceNum = {1,2,3,4,5,6};
        int n = 2;
        int min = diceNum[0]*n;
        int max = diceNum[diceNum.length-1]*n;
        int count = (int)Math.pow(6,n);
        for (int i=min; i<=max;i++){
            System.out.println("拆分 "+i+" 开始===========");
            List<int[]> list = spiltNum(i,n);
            for(int[] resi:list){
                for(int k=0 ; k<resi.length;k++){
                    System.out.print(resi[k]+" ");
                }
                System.out.println();
            }
            System.out.println("拆分 "+i+" 结束===========\n此类结果概率为 "+list.size()*100.0/count+"%");
        }
        System.out.println("理论解数量 "+count);
        return 0;
    }
    public static List<int[]> spiltNum(int num,int n){
        if(num==0&&n==0) return new ArrayList<int[]>();//解完成的标志
        if(n==0||num<=0) return null;//说明已经无解
        List<int[]> resList = null;
        for (int i=1; i<=6;i++){
            int[] res = new int[n];
            res[0] = i;
            if(num-i<0) break;//优化 只要计算的结果小于零则说明 后续计算都会小于零直接跳出
            List<int[]> subRes = spiltNum(num-i,n-1);
            if(subRes==null) continue;
            if(resList==null){
                resList = new ArrayList<int[]>();
            }
            if(subRes.size()!=0){
                for(int[] resi:subRes){
                    boolean addflag = true;
                    for(int k=0 ; k<resi.length;k++){
                        if(resi[k]==0) {
                            addflag=false;
                            break;
                        }
                    }
                    if(addflag){
                        for(int k=0 ; k<resi.length;k++){
                            res[k+1] = resi[k];
                        }
                        resList.add(Arrays.copyOf(res,res.length));
                    }
                }
            }else{
                resList.add(res);
            }
        }
        return resList;
    }





    @Test
    public void test() {
        aplusb(5,6);
//        System.out.println(1<<2);
    }
    public static int aplusb(int a, int b) {

        int sum_without_carry, carry;

        sum_without_carry = a^b; //没有进位的和
        carry = (a&b)<<1; //进位
        System.out.println(sum_without_carry);
        System.out.println(carry);
        System.out.println("=====================================");
        if(carry==0)
            return sum_without_carry;
        else
            return aplusb(sum_without_carry, carry);
    }




}
