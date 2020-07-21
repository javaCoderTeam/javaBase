package com.chen.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2020-05-15 21:14
 */
public class CacheMap<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_NODE_NUM = 100;

    private int limit;

    public CacheMap() {
        this(MAX_NODE_NUM);
    }

    public CacheMap(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V save(K key, V val) {
        return put(key, val);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

}
