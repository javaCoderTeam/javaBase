package com.chen.algorithm.study.test206;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-07 17:39
 */
public class Solution2 {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void testCase() {

        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(6);
        ListNode l1_3 = new ListNode(10);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode result = reverseList(l1_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }

}
