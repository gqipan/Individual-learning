package com.pan.concurrency.threadCommunication;

import java.util.ArrayList;
import java.util.List;

public class ListAddTest1 {
    private volatile static List<String> list = new ArrayList();

    private int size(){
        return list.size();
    }

    private void add(){
        list.add("Communication test!");
    }

    public static void main(String[] args) {
        final ListAddTest1 list = new ListAddTest1();
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        list.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加一个元素！");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-1");

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (list.size() == 5) {
                        System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
                        throw new RuntimeException();
                    }
                }
            }
        }, "Thread-2");

        thread_1.start();
        thread_2.start();
    }
}
