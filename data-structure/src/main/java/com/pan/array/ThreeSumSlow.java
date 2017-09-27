package com.pan.array;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 13:16
 * Descriptions:
 */
public class ThreeSumSlow {

    public static int count(int[] array) {
        int N = array.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (array[i] + array[j] + array[k] == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
