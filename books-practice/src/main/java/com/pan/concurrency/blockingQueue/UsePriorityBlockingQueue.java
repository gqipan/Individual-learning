package com.pan.concurrency.blockingQueue;


import java.util.concurrent.PriorityBlockingQueue;

/**
 * Author: Qipan.G
 * Date: 2017/9/7
 * Time: 14:37
 * Descriptions:
 */
public class UsePriorityBlockingQueue {


    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        Task t1 = new Task();
        t1.setId(3);
        t1.setName("id为3");

        Task t4 = new Task();
        t4.setId(4);
        t4.setName("id为4");

        Task t2 = new Task();
        t2.setId(5);
        t2.setName("id为5");


        Task t3 = new Task();
        t3.setId(1);
        t3.setName("id为1");

        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        queue.add(t4);

        System.out.println("容器：" + queue);  // 初始化放在容器中时，只会把第一个需要拿出的来的元素放在首位
        System.out.println(queue.take().getId());  // 取一次之后，会在把需要第二个取得放在首位，会进行部分排序
        System.out.println("容器：" + queue);
    }

}
