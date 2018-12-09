package com.pan.algs.array;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 13:17
 * Descriptions:
 */
public class ThreeSumFast {

    public static int count(int[] array) {
        int N = array.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.rank(-(array[i] + array[j]), array) > j){
                    count++;
                }
            }
        }
        return count;
    }
}
