package o.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MySuperUtils {
    public static <T> T[] cancat(T[] o1, T[] o2, Class<T> type) {
        T[] des = (T[]) Array.newInstance(type, o1.length + o2.length);
        System.arraycopy(o1, 0, des, 0, o1.length);
        System.arraycopy(o2, 0, des, o1.length, o2.length);
        return des;
    }

    public static <T> void printArr(T[] arr, int n) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (n > 2 && i % n == (n - 1)) {
                System.out.println();
            }

        }
    }

    public static <T> void swap(T[] arr, int id1, int id2) {
        if (id1 > arr.length - 1 || id2 > arr.length - 1 || id1 < 0 || id2 < 0) {
            throw new RuntimeException("Swap got some index OUT OF BOUND");
        }
        T temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }

    public static <T> T[] subArr(T[] arr, int start, int end, Class<T> type) {
        if (end < 0) return (T[]) Array.newInstance(type, 0);
        if (start > end) return (T[]) Array.newInstance(type, 0);
        if (start > arr.length - 1 || end > arr.length - 1) {
            throw new RuntimeException("subArr got some index OUT OF BOUND " + start + "," + end);
        }
        if (start > end) {
            throw new RuntimeException("subArr got start larger than end");
        }
        T[] newArr = (T[]) Array.newInstance(type, end - start + 1);
        System.arraycopy(arr, start, newArr, 0, newArr.length);
        return newArr;
    }

    public static Integer[] fastSort(Integer[] numArr) {
        int base = numArr.length - 1;
        if (base < 0) return numArr;
        int left = 0;
//      printArr(numArr, numArr.length);
        int right = numArr.length > 1 ? numArr.length - 2 : base;
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
        if (numArr.length <= 2) return numArr;
        Integer[] leftArr = subArr(numArr, 0, base - 1, Integer.class);
        Integer[] rightArr = subArr(numArr, base + 1, numArr.length - 1, Integer.class);
        Integer[] mid = {numArr[base]};
        leftArr = fastSort(leftArr);
        rightArr = fastSort(rightArr);
        return cancat(cancat(leftArr, mid, Integer.class), rightArr, Integer.class);
    }
}
