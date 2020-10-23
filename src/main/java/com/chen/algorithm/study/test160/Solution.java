package com.chen.algorithm.study.test160;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-02 17:40
 * @Description: zhunn 相交链表
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return b;
    }

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(1);
        ListNode l1_3 = new ListNode(8);
        ListNode l1_4 = new ListNode(7);
        ListNode l1_5 = new ListNode(5);

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(0);
        ListNode l2_3 = new ListNode(1);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l1_3;

        ListNode result = getIntersectionNode(l1_1, l2_1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
