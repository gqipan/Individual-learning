package com.pan.concurrency.concurrentUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: Qipan.G
 * Date: 2017/9/13
 * Time: 11:39
 * Descriptions:
 */
public class CyclicBarrierTest3 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.interrupt();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(cyclicBarrier.isBroken());
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
