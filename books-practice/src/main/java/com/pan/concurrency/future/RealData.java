package com.pan.concurrency.future;

import java.util.concurrent.TimeUnit;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 10:44
 * Descriptions:
 */
public class RealData implements Data {

    private String result;

    public RealData(String queryRequest){
        System.out.println("根据" + queryRequest + "进行查询，这是一个很耗时的操作..");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕，获取结果");
        result = "返回的查询结果";
    }

    @Override
    public String getRequest() {
        return this.result;
    }
}
