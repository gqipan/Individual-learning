package com.pan.array.sort;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 16:03
 * Descriptions:
 */
public class InsertionSort {

    public static void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // 把array[i] 插入到array[i-1]、array[i-2]、array[i-3]....之中
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                Comparable temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
