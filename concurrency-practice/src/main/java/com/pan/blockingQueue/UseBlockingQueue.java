package com.pan.blockingQueue;

import java.util.concurrent.*;

/**
 * Author: Qipan.G
 * Date: 2017/9/5
 * Time: 14:22
 * Descriptions:
 */
public class UseBlockingQueue {


    public static void main(String[] args) throws InterruptedException {

        /*
         * ================  ArrayBlockingQueue 数组有界阻塞队列 ==============
         */
//        BlockingQueue blockingQueue = new ArrayBlockingQueue(2);
//
//        Producer producer = new Producer(blockingQueue);
//        Consumer consumer= new Consumer(blockingQueue);
//
//        new Thread(producer).start();
//        new Thread(consumer).start();
//
//        TimeUnit.SECONDS.sleep(4);

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        queue.put("a");
        queue.put("b");

        // ========== 添加元素 put 会阻塞，offer 只会返回成功失败，add 无空闲位置，抛出异常 =============
//        queue.put("c"); // 超过了队列的界限也会阻塞，等待有空闲的位置

//        boolean offerResult = queue.offer("c");// 使用 offer，超过了队列的界限只会返回false，并不会阻塞
//        System.out.println(offerResult);

        // 等待 TimeUnit 时间，还没有空闲的位置，那么返回false
        System.out.println(queue.offer("c", 3, TimeUnit.SECONDS));

//        boolean addResult = queue.add("c"); // 使用 add 超过了队列的限制会抛出异常，IllegalStateException：Queue full， 不会阻塞
//        System.out.println(addResult);

//        // =========== 删除元素 ===========
//        System.out.println("poll: " + queue.poll()); // 获取当前位置的值，并从队列中删除
//        System.out.println("poll: " + queue.poll());
//        // 执行方法，如果队列中没有元素，等待3秒，3秒后还是没有元素，返回null
//        System.out.println("poll: " + queue.poll(3, TimeUnit.SECONDS));
//        System.out.println("remove: " + queue.remove("a")); // 返回True Or False, 并且移出特定的元素
//
//
//        // =======检查方法 peek、element 检查当前元素存不存在， 存在返回当前元素=============
//        System.out.println("element: " + queue.element());  // element 返回当前索引的元素，指向即将 peek 的元素，游标不会动
//        System.out.println("element: " + queue.element());  // 如果元素为null  抛出异常
//
//        System.out.println("peek: " + queue.peek()); // peek 特使获取当前位置的元素，不会抛出异常
//        System.out.println("peek: " + queue.peek()); // 不存在返回null
//
//
//        System.out.println(queue.size());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take()); //当前的内容为空，调用take 也会阻塞


        //=== LinkedBlockingQueue 链式无界阻塞队列, 也可以设置初始容量来设置界限。 所谓的无界就是 Integer.MAX_VALUE ======
//        BlockingQueue<String> unBoundedBlockingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<String> boundedBlockingQueue = new LinkedBlockingQueue<>(1024);
//
//        unBoundedBlockingQueue.put("a");
//        unBoundedBlockingQueue.put("b");
////        linkedBlockingQueue.put("b");
//        System.out.println(unBoundedBlockingQueue.size());
//
//        //====== 高性能无界队列
//        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    }

}
