package com.example.johnyin.interviewproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

/**
 * author:johnyin2015
 * time:2019/3/5
 * description:
 */
public class Util {

    private Util() {
        throw new AssertionError();
    }

    public static int getWordCount(String filename, String word) {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                int index = -1;
                while (line.length() >= word.length() && (index = line.indexOf(word)) != -1) {
                    count++;
                    line = line.substring(index + word.length());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    //二分查找：在一个有序的数字序列，比较查找与元数据相同的数据，找到返回对应的下表，否则返回-1
    public static <T> int binarySearch(T key, T[] arr, Comparator<T> cmp) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int res = cmp.compare(arr[mid], key);
            if (res < 0) {
                low = mid + 1;
            } else if (res > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 8, 10};
        IntComparator cmp = new IntComparator();
        int index = binarySearch(5, arr, cmp);
        System.out.println(index);
        System.out.println("=========");
        //Util util = new Util();
        int chinaCount = Util.getWordCount("D:\\observerable.txt", "china");
        System.out.println(chinaCount);
    }

}

class IntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}
