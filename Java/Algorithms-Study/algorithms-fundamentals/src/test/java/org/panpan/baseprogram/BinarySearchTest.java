package org.panpan.baseprogram;

import org.junit.Test;

/**
 * Created with Intellij IDEA.
 * Author: gongqipan@qipeipu.com
 * Date: 2016-08-25 17:43
 * Description：TestBinarySearch#rank
 */
public class BinarySearchTest {

    @Test
    public void testRank(){
        int [] array = new int[]{5,4,6,3,7,2,8,1,9};
        int [] array2 = new int[]{11,43,23,67,34};

        int key = 7;
        int index = BinarySearch.rank(key,array);

        int key2 = 67;
        int index2 = BinarySearch.rank(key2,array2);
        for (int i = 0; i< array.length; i++) {
            System.out.println("Array["+i+"]: "+array[i]);
        }
        for (int i = 0; i< array2.length; i++) {
            System.out.println("Array2["+i+"]: "+array2[i]);
        }
        System.out.println("The key in array[" + index +"]");
        System.out.println("The key in array2[" + index2 +"]");
    }

}
