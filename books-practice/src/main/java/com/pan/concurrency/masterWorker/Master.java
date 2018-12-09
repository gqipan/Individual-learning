package com.pan.concurrency.masterWorker;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 11:10
 * Descriptions:
 */
public class Master {

    // 1. 放置任务的队列容器
    private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();

    // 2. 放置Worker 的集合
    private Map<String, Thread> workersMap = new HashMap<>();

    // 3. 放置每个Worker 执行任务的结果集合
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int wokerCount){
        worker.setResultMap(resultMap);
        worker.setTaskQueue(taskQueue);

        for (int i = 0; i < wokerCount; i++) {
            this.workersMap.put(Integer.toString(i), new Thread(worker));
        }
    }

    public void submit(Task task){
        this.taskQueue.add(task);
    }

    public void excute(){
        for (Map.Entry<String, Thread> workerEntry : workersMap.entrySet()) {
            workerEntry.getValue().start();
        }
    }

    public boolean isCompile(){
        for (Map.Entry<String, Thread> workerEntry : workersMap.entrySet()) {
            if (workerEntry.getValue().getState() != Thread.State.TERMINATED)
                return false;
        }
        return true;
    }

    public int getResult(){
        int priceResult = 0;
        for (Map.Entry<String, Object> workerEntry : resultMap.entrySet()) {
            priceResult += (Integer) workerEntry.getValue();
        }
        return priceResult;
    }

}
