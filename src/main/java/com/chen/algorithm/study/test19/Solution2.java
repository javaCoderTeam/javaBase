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

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= k+1 ; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return  temp.next;
    }

}
