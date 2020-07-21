package com.chen.algorithm.study.test146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2019-12-05 22:41
 */
public class Solution {


    class LRUCache extends LinkedHashMap<Integer, Integer> {


        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
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
            return super.size() > capacity;
        }
    }


}
