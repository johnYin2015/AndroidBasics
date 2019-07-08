package com.example.johnyin.suanfa.heapSort;

import com.example.johnyin.suanfa.SortTestHelper;

/***
 * 初始化堆
 * 堆定和堆底交换
 * array[k]下-》上调整成树
 */
public class HeapSort2 {
    public static int[] heapSort(int[] array) {
        int[] arr = buildMaxMap(array);
        for (int i = array.length-1; i > 1; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(array, 0, i);
        }
        return array;
    }

    /**
     * 末节点父节点起始，一直到根节点0，反复调整
     *
     * @param array
     * @return
     */
    private static int[] buildMaxMap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
        return array;
    }

    /**
     * 根节点array[k]
     * 节点k左儿子开始，沿着节点较大孩子节点，下调
     * 相邻节点比较，根节点和左右孩子比较
     * temp放入最终位置
     *
     * @param array
     * @param k
     * @param n
     */
    private static void adjustDownToUp(int[] array, int k, int n) {

        int temp = array[k];

        for (int i = 2 * k + 1; i < n-1; i = 2 * i + 1) {//i<n

            if (i < n && array[i] <= array[i + 1]) {
                i++;
            }

            if (temp >= array[i]) {
                break;
            } else {
                array[k] = array[i];
                k = i;
            }
        }

        array[k] = temp;
    }

    public static void main(String args[]){
        int[] array = {87,45,78,32,17,65,53,9,122};
        System.out.print("构建大根堆：");
        int[] dagendui = buildMaxMap(array);
        SortTestHelper.printArray(dagendui);

        System.out.print("\n"+"大根堆排序：");
        SortTestHelper.printArray(heapSort(array));
    }
}
