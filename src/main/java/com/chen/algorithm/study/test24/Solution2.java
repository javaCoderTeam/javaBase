package com.chen.algorithm.study.test24;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * @author :  chen weijie
 * @Date: 2020-05-03 11:27
 */
public class Solution2 {


    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;


            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev.next = secondNode;

            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }


}
