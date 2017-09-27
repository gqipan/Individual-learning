package com.pan.array;

import java.util.Arrays;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 10:48
 * Descriptions: 统计一个数组中两个整数和为0的个数
 */
public class TwoSumSlow {

    public static int count(int[] array) {
        int N = array.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (array[i] + array[j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

}
