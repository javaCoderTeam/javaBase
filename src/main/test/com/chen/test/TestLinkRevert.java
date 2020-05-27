package com.chen.test;

/**
 * @author Chen WeiJie
 * @date 2020-05-27 17:26:50
 **/
public class TestLinkRevert {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode pre = new ListNode(0);
            ListNode ans = pre;
            pre.next = head;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }
            ListNode end = pre.next;
            for (int i = m; i < n; i++) {
                ListNode tmp = end.next;
                end.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            return ans.next;
        }
    }

}
