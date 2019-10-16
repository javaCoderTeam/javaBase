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
        while (temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }


}
