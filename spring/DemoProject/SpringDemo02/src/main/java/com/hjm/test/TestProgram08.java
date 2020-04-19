package com.hjm.test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Houjiemu
 * @create 2020-04-19 15:24
 */
public class TestProgram08 {
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
     * 说明：每次只能向下或者向右移动一步。
     * 举例：
     * 输入:
     * arr = [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    @Test
    public void function03(){
       int[][] arr = 
        {
          {1,3,1},
          {1,5,1},
          {4,2,1}
        };
        /**
         * 创建数组dp[m][n] dp(m,n)表示到达此处需要的最小距离
         * dp[m,n]=min(dp[m-1][n]+arr[m-1][n],dp[m][n-1]+arr[m][n-1])
         */
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[n];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //边界上的点是特殊点 他们只能通过上面的点或者左边的点到达
                if (i == 0 && j==0) {
                    dp[i][j] = arr[i][j];
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1]+arr[i][j];
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j]+arr[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j]+arr[i][j] ,dp[i][j - 1]+ arr[i][j]);
                }
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println(dp[m-1][n-1]);
    }


    /**
     * 终点路径
     * 一个机器人位于一个 m x n 网格的左上角 。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
     * 问总共有多少条不同的路径？
     */
    @Test
    public void function02() {
        //创建数组dp[m,n] 机器人达到dp[m,n]位置可以从dp[m-1,n]和dp[m,n-1]的位置上移动过来来
        //所以有dp[m,n] = dp[m-1,n]+dp[m,n-1]
        int m = 10;
        int n = 10;
        int[][] dp = new int[m][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[n];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //边界上的点是特殊点 他们只能通过上面的点或者左边的点到达
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println(dp[m-1][n-1]);
    }

    /**
     * 青蛙跳
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    @Test
    public void function01() {
        //创建数组dp[] 青蛙达到dp[n]位置可以从dp[n-1]和dp[n-2]的位置上跳上来
        //所以有dp[n] = dp[n-1]+dp[n-2]
        int n = 0;
        System.out.println("输入青蛙要跳的台阶数量");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        long[] dp = new long[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            System.out.println(dp[i]);
        }
        System.out.println("青蛙有" + dp[n - 1] + "种跳法");
    }
}
