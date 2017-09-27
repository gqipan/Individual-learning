package com.pan.array;

import java.util.Arrays;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 11:05
 * Descriptions:
 */
public class TwoSumFast {

    public static int count(int[] array){
        Arrays.sort(array);
        int N = array.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            // 因为数组经过的先排序了，所以前排的必定是负整数，只有 "-array[i]" 为正整数时才会大于i，
            // 所以才需要排除 result 介于 0 和 i之间的数据，因为之前排查过的
            if (BinarySearch.rank(-array[i], array) > i){
                count++;
            }
        }
        return count;
    }
}
