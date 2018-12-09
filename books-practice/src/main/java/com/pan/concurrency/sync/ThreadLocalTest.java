package com.pan.concurrency.sync;

public class ThreadLocalTest {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setTh(String value){
        threadLocal.set(value);
    }

    public void getTh(){
        System.out.println(Thread.currentThread().getName()+ ": " + this.threadLocal.get());
    }

    public static void main(String[] args) {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalTest.setTh("张三");
                threadLocalTest.getTh();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    threadLocalTest.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
