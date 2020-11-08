package com.chen.algorithm.znn.frequency.test146;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 14:47
 * @Description: LRU缓存机制：哈希表 + 双向链表
 */
public class LRUCache {

    class CacheNode {
        private int key;
        private int val;
        private CacheNode pre;
        private CacheNode next;

        public CacheNode() {
        }

        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, CacheNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private CacheNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new CacheNode();
        this.tail = new CacheNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        CacheNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        CacheNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }

        CacheNode newNode = new CacheNode(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        size++;

        if (size > capacity) {
            CacheNode tail = removeTail();
            cache.remove(tail.key);
            size--;
        }
    }

    public void addToHead(CacheNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(CacheNode node) {
        removeNode(node);
        addToHead(node);
    }

    public CacheNode removeTail() {
        CacheNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
