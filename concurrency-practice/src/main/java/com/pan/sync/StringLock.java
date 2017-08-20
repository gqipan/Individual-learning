package com.pan.sync;

/**
 * synchronized代码块对字符串的锁，注意String常量池的缓存功能:
 * t2
 */
public class StringLock {

    public void method() {
        //分别使用new String("abc")和"abc"
        synchronized(new String("abc")){
//        synchronized ("abc") {  //这里是一个String类型的常量锁
            try {
                while(true){
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t2");

        t1.start();  //这里本质上t1、t2抢占的是同一个String锁（"abc"）,t1一直未释放锁，导致t2无法获得锁执行代码
        t2.start(); //t2无法获取到锁，会一直出现死循环
    }
}