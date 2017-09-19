package com.pan.threadPool;

import java.util.concurrent.Executors;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 14:06
 * Descriptions:
 */
public class ScheduledJob {

    public static void main(String[] args) {
        Temp temp = new Temp();
        Executors.newScheduledThreadPool(1);
    }

}

class Temp implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
    }
}
