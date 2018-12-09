package com.pan.concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/6
 * Time: 11:17
 * Descriptions:
 */
public class Producer implements Runnable{

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue queue){
        this.blockingQueue= queue;
    }


    @Override
    public void run() {
        try {
            blockingQueue.put("1");
            TimeUnit.SECONDS.sleep(3);
            blockingQueue.put("2");
            TimeUnit.SECONDS.sleep(3);
            blockingQueue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
