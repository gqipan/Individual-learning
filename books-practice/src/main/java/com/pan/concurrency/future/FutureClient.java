package com.pan.concurrency.future;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 10:43
 * Descriptions:
 */
public class FutureClient {


    public Data request(final String queryRequest){
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryRequest);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }

}
