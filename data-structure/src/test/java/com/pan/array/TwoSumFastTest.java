package com.pan.array;

import org.junit.Test;

/**
 * Author: Qipan.G
 * Date: 2017/9/20
 * Time: 11:34
 * Descriptions:
 */
public class TwoSumFastTest {

    @Test
    public void testFast(){

        int[] array = {1,5,9,2,8,7,-3,-5,-7,6,3,4,11,20,15,-20};;
        int count = TwoSumFast.count(array);
        System.out.println(count);
    }

}
