package com.pan.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 14:06
 * Descriptions:
 */
public class ScheduledJob {

    public static void main(String[] args) {
        Temp temp = new Temp();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        Executors.newSingleThreadScheduledExecutor(T)
        // 初始时延迟5秒后开始执行，执行周期为每秒一次
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(temp, 5, 1, TimeUnit.SECONDS);
    }

}

class Temp implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
    }
}
