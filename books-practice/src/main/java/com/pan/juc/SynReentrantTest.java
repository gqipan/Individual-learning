package com.pan.juc;

public class SynReentrantTest {

    public synchronized void method1(){
        System.out.println("method1..");
        method2();
    }
    public synchronized void method2(){
        System.out.println("method2..");
        method3();
    }
    public synchronized void method3(){
        System.out.println("method3..");
    }

    public static void main(String[] args) {
        final SynReentrantTest synReentrantTest = new SynReentrantTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synReentrantTest.method1();
            }
        });
        t1.start();
    }
}
