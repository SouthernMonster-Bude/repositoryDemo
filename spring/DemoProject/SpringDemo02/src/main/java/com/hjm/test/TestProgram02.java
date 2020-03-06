package com.hjm.test;
import java.io.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month-1);
        int w = calendar.get(Calendar.DAY_OF_WEEK);
        String []arr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return arr[w-1];
    }

}

public class TestProgram02 {
    public static void main(String[] args) throws IOException {

        String res = Result.findDay(8, 5, 2015);
        System.out.println(res);

    }
}