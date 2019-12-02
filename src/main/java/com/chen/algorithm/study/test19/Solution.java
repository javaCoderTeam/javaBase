package com.chen.algorithm.study.test19;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
 * <p>
 * 正确，写的不规整
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 00:25
 */
public class Solution {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        int num = 0;

        while (pre != null) {
            num++;
            pre = pre.next;
        }
        if (num < n) {
            return null;
        }

        if (num == n) {
            head = head.next;
            return head;
        }


        ListNode pre2 = head;
        int num2 = 0;
        while (head != null) {
            num2++;
            if (num2 + n == num) {
                head.next = head.next.next;
                return pre2;
            }
            head = head.next;
        }
        return null;
    }


}
