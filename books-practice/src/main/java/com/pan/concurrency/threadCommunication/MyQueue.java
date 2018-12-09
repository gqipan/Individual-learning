package com.pan.concurrency.threadCommunication;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用wait 和 notify 来模拟往队列中添加元素和取元素
 */
public class MyQueue {

    //1 需要一个承装元素的集合
    private LinkedList<Object> list = new LinkedList<>();

    //2 需要一个计数器
    private AtomicInteger count = new AtomicInteger(0);

    //3 需要设定上限和下限
    private final int minSize = 0;

    private final int maxSize;

    public MyQueue(int size) {
        this.maxSize = size;
    }

    //4 初始化一个对象用于加锁
    private final Object lock = new Object();

    public void put(Object obj) {
        synchronized (lock) {
            while (count.get() == this.maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);

            count.incrementAndGet();
            // 唤醒另外一个线程
            lock.notify();
            System.out.println("新加入的元素为: " + obj);
        }
    }

    public Object take(){
        Object result = null;
        synchronized (lock) {
            while (count.get() == this.minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = list.removeFirst();
            count.decrementAndGet();
            lock.notify();
        }
        return result;
    }

    public int getSize() {
        return this.count.get();
    }


    public static void main(String[] args) {
        final MyQueue mq = new MyQueue(5);

        mq.put("a");
        mq.put("b");
        mq.put("c");
        mq.put("d");
        mq.put("e");

        System.out.println("当前容器的长度: " + mq.getSize());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mq.put("f");
                mq.put("g");
            }
        }, "thread-1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object o1 = mq.take();
                System.out.println("移除的元素为:" + o1);
                Object o2 = mq.take();
                System.out.println("移除的元素为:" + o2);
            }
        }, "thread-2");


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

    }
}
