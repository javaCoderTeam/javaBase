package com.chen.algorithm.study.test92;


/**
 * @author Chen WeiJie
 * @date 2020-05-27 17:39:32
 **/
public class Solution2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
            head = head.next;
        }


        for (int i = m; i < n ; i++) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }
}
