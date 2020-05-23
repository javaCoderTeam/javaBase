package com.chen.algorithm.study.test2;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-07 16:16
 */
public class Solution2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummmy = new ListNode(-1);
        ListNode curr = dummmy;

        int sum = 0;
        ListNode p1 = l1,p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum /= 10;
        }

        if (sum == 1) {
            curr.next = new ListNode(sum);
        }
        return dummmy.next;
    }
    @Test
    public void testCase() {

        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);

        l1_1.next = l1_2;
        l1_2.next = l1_3;


        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);

        l2_1.next = l2_2;
        l2_2.next = l2_3;


        ListNode result = addTwoNumbers(l1_1, l2_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);


    }



}
