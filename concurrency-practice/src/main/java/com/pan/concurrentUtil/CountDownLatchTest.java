package com.pan.concurrentUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by IntelliJ IDEA.
 * User: Pan
 * Date: 2017/9/14
 * Time: 21:48
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread partition_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("partition_1 is finish!");
                countDownLatch.countDown();
            }
        });
        Thread partition_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("partition_2 is finish!");
                countDownLatch.countDown();
            }
        });

        partition_2.start();
        partition_1.start();

        countDownLatch.await();
        System.out.println("all partition is finish!");

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
//        cyclicBarrier.reset();

    }

}
