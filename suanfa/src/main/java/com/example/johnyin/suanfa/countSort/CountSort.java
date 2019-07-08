package com.example.johnyin.suanfa.countSort;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.johnyin.suanfa.Util;
import com.example.johnyin.suanfa.mergeSort.SortTestHelper;

import java.util.Arrays;

public class CountSort {
    @RequiresApi(api = Build.VERSION_CODES.N)
    static void countSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();//9
        int min = Arrays.stream(arr).min().getAsInt();//1
        int range = max - min + 1;//9
        int count[] = new int[range];

        int n = arr.length;
        int output[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            count[arr[i] - min]++;//count[7]=1
        }
        //
        //8 2 5 9 1-->1 1 0 0 1 0 0 1 1
        for (int i = 1; i < count.length; i++)
        {
            count[i] += count[i - 1];
        }
        //-->1 2 3 3 4 4 4 5 6
        for (int i = n - 1; i >= 0; i--)
        {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        for (int i = 0; i < n; i++)
        {
            arr[i] = output[i];
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[] arr = {285,173,156,172,200,205,153};
        countSort(arr);
        Util.printArray(arr);
    }
}
