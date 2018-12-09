package com.pan.concurrency.providerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 13:07
 * Descriptions:
 */
public class Consumer implements Runnable {

    private BlockingQueue<Data> blockingQueue;
    //随机对象
    private static Random r = new Random();

    public Consumer(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true){
            try {
                Data data = this.blockingQueue.take();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("当前消费线程：" + Thread.currentThread().getName() + "， 消费成功，消费数据为id: " + data.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
