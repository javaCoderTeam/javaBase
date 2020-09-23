package com.chen.algorithm.study.test25;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
 * <p>
 * 递归
 *
 * @author :  chen weijie
 * @Date: 2020-09-20 01:29
 */
public class Solution1 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;

        while (true) {

            int count = 0;
            while (tail != null && count != k) {
                tail = tail.next;
                count++;
            }

            if (tail == null) {
                break;
            }

            ListNode head1 = pre.next;

            while (pre.next != tail) {
                ListNode curr = pre.next;
                pre.next = curr.next;
                curr.next = tail.next;
                tail.next = curr;
            }

            pre = head1;
            tail = head1;
        }


        return dummy.next;
    }


    @Test
    public void testCase() {

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        reverseKGroup(l1_1, 3);
        System.out.println("end");
    }


}
