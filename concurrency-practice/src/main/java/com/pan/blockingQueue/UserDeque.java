package com.pan.blockingQueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Author: Qipan.G
 * Date: 2017/9/7
 * Time: 14:28
 * Descriptions:
 */
public class UserDeque {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addFirst("d");
        deque.addFirst("e");
        deque.addLast("f");
        deque.addLast("g");
        deque.addLast("h");
        deque.addLast("i");
        deque.addLast("j");
        deque.offerLast("k");

        System.out.println("查看头元素：" + deque.peekFirst());
        System.out.println("获取尾元素：" + deque.pollLast());
        Object [] objs = deque.toArray();
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }

    }
}
