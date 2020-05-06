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

        ListNode  fast = head;
        ListNode  slow = head;
        int count = 0;

        while ( fast != null) {
             fast =  fast.next;
            count++;

            if (count >= k) {
                 slow =  slow.next;
            }
        }
        if (count < k) {
            return null;
        }

        return  slow;
    }

}
