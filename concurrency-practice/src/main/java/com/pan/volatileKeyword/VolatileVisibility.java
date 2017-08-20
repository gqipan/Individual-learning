package com.pan.volatileKeyword;

/**
 * 测试volatile 关键字的可见性
 */
public class VolatileVisibility implements Runnable{

    private volatile boolean isRunning = true;
    public void setRunning(boolean running) {
        isRunning = running;
    }
    @Override
    public void run() {
        System.out.println("进入了run方法......");
        while (isRunning){
            // 不能在这使用System.out.println方法, 否则isRunning对线程可见
//            System.out.println("等待isRunning 被设置为false!");
        }
        System.out.println("退出了run方法......");
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileVisibility visibility = new VolatileVisibility();
        Thread thread= new Thread(visibility);
        thread.start();
        Thread.sleep(1000);// 让主线程睡1秒
        visibility.setRunning(false);
        System.out.println("isRunning 已经被设置成了false");
    }
}
