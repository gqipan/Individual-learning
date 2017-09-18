package com.pan.concurrentUtil;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: Qipan.G
 * Date: 2017/9/18
 * Time: 10:29
 * Descriptions:
 */
public class ExchangerTest {

    private final static Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);


    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    String A = exchanger.exchange(B);
                    System.out.println("A 和 B 数据是否一致：" + A.equals(B) + "，A 录入的是：" + A + "，B 录入是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
