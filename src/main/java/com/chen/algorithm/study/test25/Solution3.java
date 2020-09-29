package com.chen.algorithm.study.test25;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 *
 * @author :  chen weijie
 * @Date: 2020-09-20 01:29
 */
public class Solution3 {

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
                count++;
                tail = tail.next;
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

}
