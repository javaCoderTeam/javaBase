package com.chen.algorithm.znn.linkedlist.test21;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * @Author: zhunn
 * @Date: 2020-09-06 01:43
 * @Description:  并两个有序链表
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode prehead = new ListNode(0);

        ListNode prev = prehead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    @Test
    public void testCase(){

        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(6);
        ListNode l1_3 = new ListNode(9);

        l1_1.next = l1_2;
        l1_2.next = l1_3;


        ListNode l2_1 = new ListNode(2);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(8);

        l2_1.next = l2_2;
        l2_2.next = l2_3;


        ListNode result = mergeTwoLists(l1_1, l2_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.val);

    }


}
