package com.pan.concurrency.threadCommunication;

import java.util.ArrayList;
import java.util.List;

public class ListAddUseNotifyAndWait {


    private volatile static List<String> list = new ArrayList();

    private int size() {
        return list.size();
    }

    private void add() {
        list.add("Communication test!");
    }

    public static void main(String[] args) {
        final ListAddUseNotifyAndWait list = new ListAddUseNotifyAndWait();
        final Object lock = new Object();
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        for (int i = 0; i < 10; i++) {
                            list.add();
                            System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加一个元素！");
                            Thread.sleep(500);
                            if (list.size() == 5) {
                                System.out.println("已经发出通知！");
                                lock.notify();// notify 方法不会释放锁
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-1");

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        if (list.size() != 5) {
                            System.out.println("Thread-2进入...");
                            lock.wait();// wait 方法会释放锁
                        }
                        System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
                        throw new RuntimeException();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        // 需要先启动 thread_2 , 因为如果先启动 thread_1， 那么 notify 方法不会释放锁，
        // t1线程完全执行完才会释放锁, 当t1到notify 方法的时候，并没有 其他线程在 wait
        thread_2.start();
        thread_1.start();
    }
}
