package com.chen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2020-08-26 10:29
 */
public class CacheMap<K, V> extends LinkedHashMap<K, V> {


    private int limit;

    public CacheMap(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public void putVal(K k, V v) {
        super.put(k, v);
    }

    public V getVal(K k) {
        return super.getOrDefault(k, (V) new Object());
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return super.size() > limit;
    }


}
