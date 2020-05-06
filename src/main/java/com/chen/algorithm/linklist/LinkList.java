package com.chen.algorithm.linklist;

/**
 * 􏷠􏲊􏲽􏱶􏷲􏳄􏰖􏳼􏷠􏲊链表中第k个节点
 * <p>
 * 两个指针第一个指针p1先开始跑，指针p1跑到k-1个节点后，另一个节点p2开始跑，当p1跑到最后时，p2所指向的指针就是第k个节点
 *
 * @author :  chen weijie
 * @Date: 2020-04-28 18:46
 */
public class LinkList {

    public static class Node {

        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public Node solution(Node head, int k) {

        Node p = head;
        Node pre = head;
        int tempK = k;
        int count = 0;

        while (p != null) {
            p = p.next;
            if (k < 1) {
                pre = pre.next;
            }
            count++;
            k--;
        }

        if (count < tempK) {
            return null;
        }
        return pre;
    }


}
