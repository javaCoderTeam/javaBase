package com.chen.algorithm.study.test21;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-06 01:10
 */
public class Solution2 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


    @Test
    public void testCase(){

        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(5);

        l1_1.next = l1_2;
        l1_2.next = l1_3;


        ListNode l2_1 = new ListNode(5);
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
