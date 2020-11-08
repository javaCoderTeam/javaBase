package com.chen.algorithm.znn.frequency.test146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: zhunn
 * @Date: 2020/11/08 14:47
 * @Description: LRU缓存机制：1-使用java的LinkedHashMap
 */
public class LRUCacheMap extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
