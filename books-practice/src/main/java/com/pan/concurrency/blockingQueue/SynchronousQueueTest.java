package com.pan.concurrency.blockingQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

/**
 * Author: Qipan.G
 * Date: 2017/9/8
 * Time: 11:29
 * Descriptions:
 */
public class SynchronousQueueTest {


    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<String> queue = new SynchronousQueue<>();

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread_2.start();

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("a");
                    queue.put("b");
                    queue.put("c");
                    queue.put("d");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread_1.start();



        countDownLatch.await();
    }


}
