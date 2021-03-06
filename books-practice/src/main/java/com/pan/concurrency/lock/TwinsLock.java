package com.pan.concurrency.lock;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Author: Qipan.G
 * Date: 2017/9/12
 * Time: 13:53
 * Descriptions:
 */
public class TwinsLock implements Lock {

    public TwinsLock() throws IllegalAccessException {
    }

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count) throws IllegalAccessException {
            if (count <= 0){
                throw new IllegalAccessException("count must large than zero.");
            }
            setState(count);
        }

        public int tryAcquireShared(int reduceCount){
            for (;;){
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }

        public boolean tryReleseShared(int returnCount){
            for (;;){
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }

    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
