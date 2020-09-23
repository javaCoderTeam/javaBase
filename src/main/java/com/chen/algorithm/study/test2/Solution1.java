package com.chen.algorithm.study.test2;

import org.junit.Test;

/**
 * 需要思考下，写了好久才写出来
 * @author :  chen weijie
 * @Date: 2019-09-02 23:05
 */
public class Solution1 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){

            if (l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(carry % 10);
            p = p.next;
            carry = carry /10;
        }
        return  dummy.next;
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
