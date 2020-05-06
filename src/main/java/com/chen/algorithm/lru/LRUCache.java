package com.chen.algorithm.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  * LRU缓存算法的实现
 *  * https://blog.csdn.net/qq_26440803/article/details/83795122
 *
 * @author :  chen weijie
 * @Date: 2020-04-29 23:04
 */
public class LRUCache<V> {


    class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;
    }


    private int capacity = 1024;

    private Map<String, Node<String, V>> table = new ConcurrentHashMap<>();

    private Node<String, V> head;

    private Node<String, V> tail;

    public LRUCache(int capacity) {
        this();
        this.capacity = capacity;
    }

    public LRUCache() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public V get(String key) {

        Node<String, V> node = table.get(key);
        //如果Node不在表中，代表缓存中并没有
        if (node == null) {
            return null;
        }
        //如果存在，则需要移动Node节点到表头
        //截断链表，node.prev -> node  -> node.next ====> node.prev -> node.next
        //         node.prev <- node <- node.next  ====>  node.prev <- node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //移动节点到表头
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        //存在缓存表
        table.put(key, node);
        return node.value;
    }

    public void put(String key, V value) {
        Node<String, V> node = table.get(key);
        //如果Node不在表中，代表缓存中并没有
        if (node == null) {
            if (table.size() == capacity) {
                //超过容量了 ,首先移除尾部的节点
                table.remove(tail.prev.key);
                tail.prev = tail.next;
                tail.next = null;
                tail = tail.prev;

            }
            node = new Node<>();
            node.key = key;
            node.value = value;
            table.put(key, node);
        }
        //如果存在，则需要移动Node节点到表头
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;


    }


}
