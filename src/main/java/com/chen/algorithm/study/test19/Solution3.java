package com.chen.algorithm.study.test19;

/**
 * 正确，写的不规整
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 00:25
 */
public class Solution3 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode fast = pre;
        ListNode slow = pre;

        for (int i = 0; i < n-1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }


}
