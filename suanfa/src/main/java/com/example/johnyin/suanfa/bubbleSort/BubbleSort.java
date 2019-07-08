package com.example.johnyin.suanfa.bubbleSort;

import com.example.johnyin.suanfa.mergeSort.SortTestHelper;

public class BubbleSort {

    public static Integer[] sort(Integer[] arr) {
        //依次比较两个相邻的元素，在第i轮中
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
        Integer[] arr = {285,173,156,172,200,205,153};
        Integer[] resultArr = sort(arr);
        SortTestHelper.printArray(sort(arr));
    }

}
