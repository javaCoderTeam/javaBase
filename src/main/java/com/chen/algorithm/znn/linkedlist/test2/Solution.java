package com.chen.algorithm.znn.linkedlist.test2;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
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


        ListNode result = addTwo(l1_1, l2_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);


    }


}
