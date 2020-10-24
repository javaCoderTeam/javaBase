package com.chen.algorithm.znn.linkedlist.test24;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/23 10:48
 * @Description: 两两交换链表中结点：1-递归，2-迭代
 */
public class Solution {


    /**
     * 1-递归
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 2-迭代
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }
        return dummyHead.next;
    }

    /**
     * 2-迭代（操作head）
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (head != null && head.next != null) {
            ListNode node1 = head;
            ListNode node2 = head.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
            head = node1.next;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode result = swapPairs3(l1_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
    }
}
