package com.pan.providerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 13:14
 * Descriptions:
 */
public class Provider implements Runnable {

    private BlockingQueue<Data> blockingQueue;

    private volatile boolean isRunning = true;

    private static AtomicInteger count = new AtomicInteger();

    private static Random random = new Random();

    public Provider(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (isRunning) {
            try {
                //随机休眠0 - 1000 毫秒 表示获取数据(产生数据的耗时)
                Thread.sleep(random.nextInt(1000));
                //获取的数据进行累计...
                int id = count.incrementAndGet();
                //比如通过一个getData方法获取了
                Data data = new Data(Integer.toString(id), "数据" + id);
                System.out.println("当前线程:" + Thread.currentThread().getName() + ", 获取了数据，id为:" + id + ", 进行装载到公共缓冲区中...");
                if (!this.blockingQueue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("提交缓冲区数据失败....");
                    //do something... 比如重新提交
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stop() {
        this.isRunning = false;
    }
}
