package com.pan.array;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 10:41
 * Descriptions: 二分查找法， 前提是需要数组是按照顺序排序的
 */
public class BinarySearch {

    public static int rank(int key, int[] array) {
        int low = 0;
        int height = array.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (key < array[mid])
                height = mid - 1;
            else if (key > array[mid])
                low = mid + 1;
            else return mid;
        }
        return -1;
    }


}
