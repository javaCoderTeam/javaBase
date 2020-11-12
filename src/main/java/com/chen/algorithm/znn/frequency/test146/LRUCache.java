package com.chen.algorithm.znn.frequency.test146;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 14:47
 * @Description: LRU缓存机制：哈希表 + 双向链表（手动实现）
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
