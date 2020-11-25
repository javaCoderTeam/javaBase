package com.chen.algorithm.znn.linkedlist.test24;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * @Auther: zhunn
 * @Date: 2020/10/23 10:48
 * @Description: 两两交换链表中结点：1-递归，2-迭代(推荐)
 */
public class Solution {


    /**
     * 1-递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 2-迭代（推荐）
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            node1.next = node2.next;
            node2.next = temp.next;     //等价于 node2.next = node1;
            temp.next = node2;      //两两交换  画图演示，想着图写代码

            temp = node1;   // 临时结点往前推进
        }
        return dummyHead.next;
    }

    /**
     * 2-迭代（操作head）
     *
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (head != null && head.next != null) {
            ListNode node1 = head;
            ListNode node2 = head.next;

            node1.next = node2.next;
            node2.next = temp.next;
            temp.next = node2;

            temp = node1;
            head = node1.next;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode result = swapPairs2(l1_1);

        ListNode a = result;
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
