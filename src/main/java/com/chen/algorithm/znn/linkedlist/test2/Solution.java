package com.chen.algorithm.znn.linkedlist.test2;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * @Author: zhunn
 * @Date: 2020-10-20 17:43
 * @Description: 两数相加
 */
public class Solution {


    public ListNode addTwo(ListNode a, ListNode b) {

        ListNode result = new ListNode(-1);
        ListNode curr = result;


        int carry = 0;

        while (a != null || b != null || carry != 0) {

            if (a != null) {
                carry += a.val;
                a = a.next;
            }

            if (b != null) {
                carry += b.val;
                b = b.next;
            }
            curr.next = new ListNode(carry % 10);
            carry = carry / 10;
            curr = curr.next;
        }
        return  result.next;
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


        ListNode result = addTwo(l1_1, l2_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);


    }


}
