package com.hjm.test;

import o.test.MySuperUtils;
import o.test.OthersQuickSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/***
 * 1.第n大的元素 （快速排序）
 * 2.合并数组排序
 * 3.字符串下表偏移
 */
public class TestProgram06 {

    @Test
    public void test03(){
        StringBuilder str = new StringBuilder("abcdefghijk");
        System.out.println(str.toString());
        int offset = 201;
        offset= offset%str.length();
        str = new StringBuilder()
                .append(str.substring(offset,str.length()))
                .append(str.substring(0,offset));
        System.out.println(str.toString());
    }
    @Test
    public void test02(){
        Integer[] arr1= {1,5,48,54,2,4,4};
        Integer[] arr2 ={9,54,45,84,8,4,4,4,1,1,989,0};
        Integer[] res = MySuperUtils.cancat(arr1,arr2,Integer.class);
        MySuperUtils.printArr(res,res.length);
        res = MySuperUtils.fastSort(res);
        MySuperUtils.printArr(res,res.length);
    }
    @Test
    public void test01(){
        for (int i=0;i<100;i++){
            run();
        }
        run();
    }

    public void run() {
        int n = 1000000;
//        Integer[] numArr = {214,651,119,386,891,949,662,841,518,799,589};
//        Integer[] numArr = {585,901,812,557,615,675,998,974,965,858,754,871,546,738,800,868,922,683,684,877,537,698,840,884,782,863,585,677,677,726,608,947,855,545,666,678,665,688,968,841,809,826,692,932,936,968};
        Integer[] numArr = new Integer[n];
        for (int i = 0; i < numArr.length; i++) numArr[i] = (int) (Math.random() * n);
//        System.out.println("开始=========================================");
//        MySuperUtils.printArr(numArr, numArr.length);
        numArr = fastSort(numArr);
//        System.out.println("结果=========================================");
//        MySuperUtils.printArr(numArr, numArr.length);
//        System.out.println("检查=========================================");
        for (int i = 1; i < numArr.length; i++) {
            if(numArr[i-1]>numArr[i]){
                System.out.println("检查到错误"+numArr[i-1]+">"+numArr[i]);
                MySuperUtils.printArr(numArr, numArr.length);
                break;
            }
            if(i==numArr.length-1){
//                System.out.println("检查无异常=========================================");
            }
        }

//        System.out.println("完成=========================================");
    }

    public static Integer[] fastSort(Integer[] numArr) {
        int base = numArr.length - 1;
        if (base < 0) return numArr;
        int left = 0;
//        MySuperUtils.printArr(numArr, numArr.length);
        int right = numArr.length > 1 ? numArr.length - 2 : base;
        while (left < right) {
            while (left < right && numArr[left] <= numArr[base]) left++;
            while (left < right && numArr[right] >= numArr[base]) right--;
            if (left < right && numArr[left] > numArr[base] && numArr[right] < numArr[base])
                MySuperUtils.swap(numArr, left, right);
        }
        if (numArr[left] > numArr[base]) {
            MySuperUtils.swap(numArr, base, left);
            base = left;
        } else if (numArr[right] > numArr[base]) {
            MySuperUtils.swap(numArr, base, right);
            base = right;
        }
        if (numArr.length <= 2) return numArr;
        Integer[] leftArr = MySuperUtils.subArr(numArr, 0, base - 1, Integer.class);
        Integer[] rightArr = MySuperUtils.subArr(numArr, base + 1, numArr.length - 1, Integer.class);
        Integer[] mid = {numArr[base]};
        leftArr = fastSort(leftArr);
        rightArr = fastSort(rightArr);
        return MySuperUtils.cancat(MySuperUtils.cancat(leftArr, mid, Integer.class), rightArr, Integer.class);
    }
    public static Integer[] fastSort2(Integer[] numArr,int left,int right) {
        int left0 = left;
        int right0 = right;
        int base = right ;
        right = right -1;
        if (right < left) return numArr;
        while (left < right) {
            while (left < right && numArr[left] <= numArr[base]) left++;
            while (left < right && numArr[right] >= numArr[base]) right--;
            if (left < right && numArr[left] > numArr[base] && numArr[right] < numArr[base])
                MySuperUtils.swap(numArr, left, right);
        }
        if (numArr[left] > numArr[base]) {
            MySuperUtils.swap(numArr, base, left);
            base = left;
        } else if (numArr[right] > numArr[base]) {
            MySuperUtils.swap(numArr, base, right);
            base = right;
        }
        fastSort2(numArr,left0,base-1);
        fastSort2(numArr,base+1,right0);
        return numArr;
    }
    private static void swap(int[] arr, int id1, int id2){
        if (id1 > arr.length - 1 || id2 > arr.length - 1 || id1 < 0 || id2 < 0) {
            throw new RuntimeException("Swap got some index OUT OF BOUND");
        }
        int temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }
    public static int[] fastSort3(int[] numArr,int left,int right) {
        int left0 = left;
        int right0 = right;
        int base = right ;
        right = right -1;
        if (right < left) return numArr;
        while (left < right) {
            while (left < right && numArr[left] <= numArr[base]) left++;
            while (left < right && numArr[right] >= numArr[base]) right--;
            if (left < right && numArr[left] > numArr[base] && numArr[right] < numArr[base])
                swap(numArr, left, right);
        }
        if (numArr[left] > numArr[base]) {
            swap(numArr, base, left);
            base = left;
        } else if (numArr[right] > numArr[base]) {
            swap(numArr, base, right);
            base = right;
        }
        fastSort3(numArr,left0,base-1);
        fastSort3(numArr,base+1,right0);
        return numArr;
    }
    @Test
    public void test04() {
        int n = 100000000;
//        Integer[] numArr = {214,651,119,386,891,949,662,841,518,799,589};
//        Integer[] numArr = {585,901,812,557,615,675,998,974,965,858,754,871,546,738,800,868,922,683,684,877,537,698,840,884,782,863,585,677,677,726,608,947,855,545,666,678,665,688,968,841,809,826,692,932,936,968};
        Integer[] numArr = new Integer[n];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < numArr.length; i++) numArr[i] = (int) (Math.random() * n * 10);
//        System.out.println("开始=========================================");
//        MySuperUtils.printArr(numArr, numArr.length);
        numArr = fastSort2(numArr,0,numArr.length-1);
//        System.out.println("结果=========================================");
//        MySuperUtils.printArr(numArr, numArr.length);
//        System.out.println("检查=========================================");
        for (int i = 1; i < numArr.length; i++) {
            if(numArr[i-1]>numArr[i]){
                System.out.println("检查到错误"+numArr[i-1]+">"+numArr[i]);
//                MySuperUtils.printArr(numArr, numArr.length);
                break;
            }
            if(i==numArr.length-1){
//                System.out.println("检查无异常=========================================");
            }
        }
        System.out.println();
        System.out.println("完成========================================="+(System.currentTimeMillis()-t1)/1000+"s");
    }

    @Test
    public void test05() {
        int n = 100000000;
//        Integer[] numArr = {214,651,119,386,891,949,662,841,518,799,589};
//        Integer[] numArr = {585,901,812,557,615,675,998,974,965,858,754,871,546,738,800,868,922,683,684,877,537,698,840,884,782,863,585,677,677,726,608,947,855,545,666,678,665,688,968,841,809,826,692,932,936,968};
        Integer[] numArr = new Integer[n];
        int[] arr = new int[n];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * n * 10);
            arr[i] = numArr[i];
        }
//        System.out.println("开始=========================================");
//        MySuperUtils.printArr(numArr, numArr.length);
//        long t1 = System.currentTimeMillis();
//        numArr = fastSort2(numArr,0,numArr.length-1);
//        System.out.println("fastSort2 完成========================================="+(System.currentTimeMillis()-t1)/1000+"s");
//        t1 = System.currentTimeMillis();
//        numArr = fastSort(numArr);//爆内存溢出
//        System.out.println("fastSort 完成========================================="+(System.currentTimeMillis()-t1)/1000+"s");

        ///////
        long t1 = System.currentTimeMillis();
        OthersQuickSort quicksort = new OthersQuickSort();
        quicksort.sort(arr);
        System.out.println("OthersQuickSort 完成========================================="+(System.currentTimeMillis()-t1)/1000+"s");
//        fastSort3(arr,0,arr.length-1);
//        System.out.println("fastSort3 完成12========================================="+(System.currentTimeMillis()-t1)/1000+"s");
//        for (int i = 1; i < numArr.length; i++) {
//            if(numArr[i-1]>numArr[i]){
//                System.out.println("numArr检查到错误"+numArr[i-1]+">"+numArr[i]);
////                MySuperUtils.printArr(numArr, numArr.length);
//                break;
//            }
//        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]>arr[i]){
                System.out.println("arr检查到错误"+arr[i-1]+">"+arr[i]);
//                MySuperUtils.printArr(numArr, numArr.length);
                break;
            }
        }
    }


}
