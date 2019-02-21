package com.chen.algorithm.exercise;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author :  chen weijie
 * @Date: 2019-02-21 11:21 PM
 * <p>
 * 一种方法是利用栈来实现；
 * 另外一种方法是利用三个指针把链表反转，关键是 r 指针保存断开的节点。
 */
public class PrintLinkList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if (listNode == null) {
                return new ArrayList<>();
            }

            //使用三个指针反转，
            ListNode head = listNode;
            ListNode curr = listNode.next;
            ListNode temp;
            while (curr != null) {
                temp = curr.next;
                curr.next = head;
                head = curr;
                curr = temp;
            }
            listNode.next = null;

            //遍历
            ArrayList<Integer> res = new ArrayList<Integer>();
            while (head != null) {
                res.add(head.val);
                head = head.next;
            }
            return res;


        }
    }


}
