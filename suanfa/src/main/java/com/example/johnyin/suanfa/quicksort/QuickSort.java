package com.example.johnyin.suanfa.quicksort;

public class QuickSort {

    static void sort(int[] arr,int l,int r){//?
        if(l>=r){
            return;
        }

        int p = partition(arr, l, r);//命名？

        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    private static int partition(int[] arr, int l, int r) {
        return 0;
    }
}
