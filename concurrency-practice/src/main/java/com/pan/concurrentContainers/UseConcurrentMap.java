package com.pan.concurrentContainers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Qipan.G
 * Date: 2017/8/22
 * Time: 17:22
 * Descriptions:
 */
public class UseConcurrentMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<>();
        chm.put("k1", "v1");
        chm.put("k2", "v2");
        chm.put("k3", "v3");

        chm.putIfAbsent("k3", "vvvv");

        System.out.println(chm.get("k2"));
        System.out.println(chm.size());

        for(Map.Entry<String, Object> me : chm.entrySet()){
            System.out.println("key:" + me.getKey() + ",value:" + me.getValue());
        }

    }
}
