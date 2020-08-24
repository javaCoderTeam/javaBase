package com.chen.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2020-08-03 10:38
 */
public class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {

    private int limit;

    public LRUCacheMap(int capcity) {
        super(capcity, 0.75f, true);
        this.limit = capcity;
    }

    public V getValue(K key) {
        return super.get(key);
    }

    public void putVal(K key, V value) {
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> oldEntry) {
        return super.size() > limit;
    }

}
