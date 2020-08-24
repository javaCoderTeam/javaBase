package com.chen.algorithm.study.test83;

/**
 * @author :  chen weijie
 * @Date: 2019-09-08 01:55
 */
public class Solution {


    public ListNode deleteDuplicates(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return temp;
    }


}
