package com.pan.concurrency.sync;

/**
 * synchronized异常
 */
public class SyncException {

    private int i = 0;

    /**
     * 例如对于一个整体性的20个线程，整体都要成功的话，那么就需要处理 synchronized 异常
     * synchronized 出现异常，锁自动释放
     */
    public synchronized void operation() {
        while (true) {
            try {
                i++;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " , i = " + i);
                if (i == 10) {
                    Integer.parseInt("a");
                }
            } catch (Exception e) {//可以使用中断异常：InterruptedException
                System.out.println(" log info index: " + i);
                e.printStackTrace();
//                throw new RuntimeException(); // 也可以抛出异常
            }
        }
    }

    public static void main(String[] args) {
        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.operation();
            }
        }, "t1");
        t1.start();
    }
}

