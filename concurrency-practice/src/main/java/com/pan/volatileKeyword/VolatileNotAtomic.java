package com.pan.volatileKeyword;

/**
 * volatile不能保证原子性
 */
public class VolatileNotAtomic {

    private static volatile int count;
    private static void increase(){
        count++;
    }
    private static final int THREAD_COUNT = 20;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (Thread thread : threads) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(count);//输出的结果并不等于200000
    }
}
