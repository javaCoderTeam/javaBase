package com.chen.algorithm.study.test92;


import org.junit.Test;

/**
 * @author Chen WeiJie
 * @date 2020-05-27 17:39:32
 * @Description: zhunn 反转链表2
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

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(7);
        ListNode l1_2 = new ListNode(9);
        ListNode l1_3 = new ListNode(2);
        ListNode l1_4 = new ListNode(10);
        ListNode l1_5 = new ListNode(1);
        ListNode l1_6 = new ListNode(8);
        ListNode l1_7 = new ListNode(6);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = l1_6;
        l1_6.next = l1_7;

        ListNode result = reverseBetween(l1_1,3,6);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.next.val);
    }


}
