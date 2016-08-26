package org.panpan.baseprogram;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Author: gongqipan@qipeipu.com
 * Date: 2016-08-25 17:32
 * Description：二分查找法
 */
public class BinarySearch {


    public static int rank(int key, int[] array) {

        //Array sort
        Arrays.sort(array);
        int low = 0;
        int height = array.length - 1;
        while (low <= height) {
            int mid = height + low / 2;
            if (key > array[mid]) {
                low = mid + 1;
            } else if (key < array[mid]) {
                height = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
