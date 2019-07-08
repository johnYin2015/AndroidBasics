package com.example.johnyin.suanfa;

public class InsertionSort {
    public static Object[] sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);

        Object[] array = sort(arr);
//        SortTestHelper.printArray(array);
        //SortTestHelper.testSort("com.example.johnyin.suanfa.InsertionSort", arr);

        return;
    }
}
