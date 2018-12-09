package com.pan.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 16:06
 * Descriptions:
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
    }
}
