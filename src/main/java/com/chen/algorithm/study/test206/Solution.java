package com.chen.algorithm.study.test206;

import org.junit.Test;

import java.util.Stack;

/**
 * 空间和时间复杂度都不满足要求
 *
 * @author :  chen weijie
 * @Date: 2019-09-06 02:00
 */
public class Solution {


    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }


        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (!stack.empty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return node.next;
    }


    @Test
    public void testCase() {

        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(6);
        ListNode l1_3 = new ListNode(9);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode result = reverseList(l1_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }

}
