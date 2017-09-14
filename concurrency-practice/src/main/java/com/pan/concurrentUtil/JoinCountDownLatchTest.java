package com.pan.concurrentUtil;

public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        Thread patition_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("partition_1 is finsh!");
            }
        });
        Thread patition_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("partition_1 is finsh!");
            }
        });

        patition_1.start();
        patition_2.start();

        patition_1.join();
        patition_2.join();

        System.out.println("Excel is fish!");

    }
}
