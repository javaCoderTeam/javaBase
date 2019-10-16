package com.chen.algorithm.study.test2;

import org.junit.Test;

/**
 * 需要思考下，写了好久才写出来
 * @author :  chen weijie
 * @Date: 2019-09-02 23:05
 */
public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l3 = result;
        int nextNum = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int num = x + y + nextNum;
            nextNum = 0;
            if (num > 9) {
                num = num % 10;
                nextNum = 1;
            }
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            l3.next = new ListNode(num);
            l3 = l3.next;
        }

        if (nextNum > 0) {
            l3.next = new ListNode(nextNum);
        }
        return result.next;
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
