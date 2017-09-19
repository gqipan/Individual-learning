package com.pan.concurrentUtil;

import java.util.concurrent.*;

/**
 * Author: Qipan.G
 * Date: 2017/9/18
 * Time: 10:14
 * Descriptions:
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);

        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //申请许可，最大可允许10个线程获取资源
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + ": sava data");
                        TimeUnit.SECONDS.sleep(5);
                        semaphore.release();  //  释放后才能继续获取
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        threadPool.shutdown();
    }
}
