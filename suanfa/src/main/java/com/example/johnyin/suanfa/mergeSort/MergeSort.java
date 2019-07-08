package com.example.johnyin.suanfa.mergeSort;

import com.example.johnyin.suanfa.SortTestHelper;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {

        //左半部分的指针超出右半部分的指针
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //new新数组存放合并的元素
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        //左半部分元素的起始指针，右半部分元素的起始指针
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            //左半部分元素全部处理完
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;//保存右半部分元素
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        sort(arr);
        com.example.johnyin.suanfa.mergeSort.SortTestHelper.printArray(arr);
        //SortTestHelper.testSort("com.example.johnyin.suanfa.mergeSort.MergeSort", arr);

        return;
    }
}
