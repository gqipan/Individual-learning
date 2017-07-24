package com.pan.design.proxy;

import java.util.Map;

/**
 * Created by Pan on 2017/7/24.
 */
public class Cache<T> {

    private Map<String, T> cacheBuffer;

    private static Cache cache;

    private Cache(){}

    public static Cache getInstans(){ //Double Check
        if (cache == null){
            synchronized(Cache.class){
                if (cache == null){
                    cache = new Cache();
                }
            }
        }
        return cache;
    }

    public void putCache(String key, T value){
        cacheBuffer.put(key, value);
    }

    public T getValue(String key){
        return cacheBuffer.get(key);
    }

}
