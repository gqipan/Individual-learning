package com.pan.masterWorker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 11:14
 * Descriptions:
 */
public class Worker implements Runnable{


    // 1. 放置任务的队列容器
    private ConcurrentLinkedQueue<Task> taskQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while(true){
            Task task = this.taskQueue.poll();
            if (task == null) break;
            Object result = handle(task);
            this.resultMap.put(Integer.toString(task.getId()), result);
        }

    }

    private Object handle(Task task){
        Object result =  null;
        try {
            TimeUnit.SECONDS.sleep(3);
            result = task.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
