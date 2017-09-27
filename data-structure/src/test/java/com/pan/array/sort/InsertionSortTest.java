package com.pan.array.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 17:44
 * Descriptions:
 */
public class InsertionSortTest {

    @Test
    public void test(){
        Integer[] array = {5, 1, 2, 7, 6, 4, 3, 10, 9, 15};
        System.out.println("排序前：" + Arrays.asList(array));
        InsertionSort.sort(array);
        System.out.println("排序后：" + Arrays.asList(array));
    }

}
