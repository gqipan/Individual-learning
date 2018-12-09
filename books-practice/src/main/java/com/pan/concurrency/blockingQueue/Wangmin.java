package com.pan.concurrency.blockingQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/7
 * Time: 13:46
 * Descriptions: 网民
 */
public class Wangmin implements Delayed {


    private String name;
    /**
     * 身份证
     */
    private String id;
    /**
     * 截止时间
     */
    private long endTime;

    /**
     * 时间工具类
     */
    private TimeUnit timeUnit = TimeUnit.SECONDS;


    public Wangmin(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    /**
     * 用来判断是否到了截止时间。
     * DelayQueue  将会在每个元素的  getDelay()  方法返回的值的时间段之后才释放掉该元素。
     * 如果返回的是  0  或者负值，延迟将被认为过期， 该元素将会在  DelayQueue  的下一次  take 被调用的时候被释放掉。
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Wangmin w = (Wangmin) o;
        return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1:0;
    }
}
