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

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode ans = pre;

        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        ListNode end = pre.next;

        for (int i = m; i < n ; i++) {
            ListNode temp = end.next;
            end.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return ans.next;
    }
}
