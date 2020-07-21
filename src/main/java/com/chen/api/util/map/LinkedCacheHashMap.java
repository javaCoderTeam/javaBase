package com.chen.api.util.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2020-06-29 01:06
 */
public class LinkedCacheHashMap<K, V> extends LinkedHashMap<K, V> {


    private static int defaul_limt = 100;

    private int limt;

    public LinkedCacheHashMap() {
        this(defaul_limt);
    }

    public LinkedCacheHashMap(Integer size) {
        super(size, 0.75f, true);
        this.limt = size;
    }

    public V getV(K key) {
        return get(key);
    }

    public void save(K key, V value) {
        put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> value) {
        return super.size() > limt;
    }


}
