package com.chen.algorithm.study.test24;

import org.junit.Test;

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
            secondNode.next = prev.next;
            prev.next = secondNode;

            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }


    @Test
    public void test(){
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;

        ListNode result = swapPairs(l1_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
    }
}
