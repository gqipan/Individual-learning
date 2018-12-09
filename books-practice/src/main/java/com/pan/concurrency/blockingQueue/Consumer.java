package com.pan.concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/6
 * Time: 11:20
 * Descriptions:
 */
public class Consumer implements Runnable{

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
