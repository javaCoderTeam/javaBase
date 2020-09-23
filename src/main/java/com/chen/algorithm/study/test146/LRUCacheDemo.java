package com.chen.algorithm.study.test146;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 *
 * @author :  chen weijie
 * @Date: 2019-12-05 23:11
 */
public class LRUCacheDemo {

    class DoubleLinkedListNode {
        int k;
        int v;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;

        public DoubleLinkedListNode() {
        }

        public DoubleLinkedListNode(int key, int value) {
            this.k = key;
            this.v = value;
        }
    }


    private HashMap<Integer, DoubleLinkedListNode> hashMap = new HashMap<>();
    private int size;
    private int capcity;
    private DoubleLinkedListNode head, tail;

    public LRUCacheDemo(int capcity, int value) {
        this.size = 0;
        this.capcity = capcity;
        DoubleLinkedListNode head = new DoubleLinkedListNode();
        DoubleLinkedListNode tail = new DoubleLinkedListNode();
        head.next = tail;
        tail.pre = head;
    }


    public int getValue(int key) {



        return 0;

    }

    public void put() {


    }


    public void removeNode() {


    }


    public void moveToHead() {


    }

    public void addToHead() {


    }

    public void removeTail() {

    }


}
