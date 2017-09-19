package com.pan.future;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 10:44
 * Descriptions:
 */
public class FutureData implements Data {

    private RealData realData;
    private static ReentrantLock REENTRANT_LOCK = new ReentrantLock();
    private static Condition condition = REENTRANT_LOCK.newCondition();
    private boolean isRead = false;

    public void setRealData(RealData realData){
        REENTRANT_LOCK.lock();
        try {
            if (isRead){
                return;
            }
            this.realData = realData;
            isRead = true;
            condition.signal();
        }finally {
            REENTRANT_LOCK.unlock();
        }
    }

    @Override
    public String getRequest() {
        REENTRANT_LOCK.lock();
        try {
            while (!isRead) {
                condition.await();
            }
            return this.realData.getRequest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            REENTRANT_LOCK.unlock();
        }
        return null;
    }
}
