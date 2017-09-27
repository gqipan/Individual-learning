package com.pan.array.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 15:45
 * Descriptions:
 */
public class SelectionSortTest {

    @Test
    public void test(){
        Integer[] array = {5, 1, 2, 7, 6, 4, 3, 10, 9, 15};
        System.out.println("排序前：" + Arrays.asList(array));
        SelectionSort.sort(array);
        System.out.println("排序后：" + Arrays.asList(array));
    }
}
