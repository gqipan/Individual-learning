package com.pan.algs.array.sort;

import java.util.Arrays;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 15:32
 * Descriptions:
 */
public class SelectionSort {

    public static void sort(Comparable[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if (less(array[j], array[minIndex])){
                    minIndex = j;
                }
            }
            // 交互 minIndex 和 i
            Comparable temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            System.out.println("第" + (i+1) + "次排序： " + Arrays.asList(array));
        }
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
