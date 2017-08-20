package com.pan.threadCommunication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListAddUseCountDownLatch {
    private volatile static List<String> list = new ArrayList();

    private int size() {
        return list.size();
    }

    private void add() {
        list.add("Communication test!");
    }

    public static void main(String[] args) {
        final ListAddUseCountDownLatch list = new ListAddUseCountDownLatch();

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        list.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加一个元素！");
                        Thread.sleep(500);
                        if (list.size() == 5) {
                            System.out.println("已经发出通知！");
                            countDownLatch.countDown();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (list.size() != 5) {
                        System.out.println("Thread-2进入...");
                        countDownLatch.await();
                    }
                    System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
                    throw new RuntimeException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        thread_1.start();
        thread_2.start();
    }
}
