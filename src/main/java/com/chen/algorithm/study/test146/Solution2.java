package com.chen.algorithm.study.test146;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 *
 * @author :  chen weijie
 * @Date: 2019-12-05 23:11
 */
public class Solution2 {

    class Node {

        public int key, val;

        public Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }


    class DoubleList {

        private Node head, tail;

        private int size;


        public DoubleList() {

            this.size = 0;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node x) {

            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }


        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() {
            return size;
        }
    }


    class LRUCache {


        private HashMap<Integer, Node> map;

        private DoubleList cache;

        private int cap;

        public LRUCache(int capacity) {

            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {

            if (!map.containsKey(key))
                return -1;
            int val = map.get(key).val;
            // 利用 put 方法把该数据提前
            put(key, val);
            return val;
        }

        public void put(int key, int value) {

            Node x = new Node(key, value);

            if (map.containsKey(key)) {
                // 删除旧的节点，新的插到头部
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cap == cache.size) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }


    }


}
