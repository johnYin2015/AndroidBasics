package com.example.johnyin.suanfa.countSort;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.johnyin.suanfa.Util;

import java.util.Arrays;

public class CountSort2 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void countSort(int[] arr) {
        //最值
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        //范围
        int range = max - min + 1;
        //中间数组，即排序数组
        int[] count = new int[range];

        //输出数组，赋值给原数组
        int n = arr.length;
        int[] output = new int[n];

        //把待排序数组元素作为下标，统计元素出现的个数
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        //当前项 = 它自身 + 它前一项
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }//##

        //原数组赋值给输出数组
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
        }

        //输出数组赋值给原数组
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[] arr = {285, 173, 156, 172, 200, 205, 153};
        countSort(arr);
        Util.printArray(arr);
    }
}
