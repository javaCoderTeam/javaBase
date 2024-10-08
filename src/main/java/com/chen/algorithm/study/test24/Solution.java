package com.chen.algorithm.study.test24;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * @author :  chen weijie
 * @Date: 2020-05-03 11:27
 */
public class Solution {


    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummy = pre;


        // a->b->c->d
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            firstNode.next = secondNode.next;
            secondNode.next = pre.next;
            pre.next = secondNode;

            pre = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    /**
     * 自己写的 错误的，等自己熟悉后，把这个改对
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        ListNode curr = head;
        ListNode next = head.next;
        ListNode nextNext = null;

        while (curr != null && next != null) {
            nextNext = next.next;
            next.next = curr;
            curr.next = nextNext;
            curr = nextNext.next;
            if (curr != null) {
                next = curr.next;
            }
        }
        return head.next;
    }


}
