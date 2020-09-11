package com.chen.algorithm.study.test19;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 21:56
 */
public class Solution2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null){
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;

        for (int i = 0; i < k ; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return  pre.next;
    }

}
