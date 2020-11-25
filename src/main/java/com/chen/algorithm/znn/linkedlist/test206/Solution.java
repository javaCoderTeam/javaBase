package com.chen.algorithm.znn.linkedlist.test206;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @Auther: zhunn
 * @Date: 2020/10/22 17:23
 * @Description: 反转链表：1-双指针法（推荐），2-递归
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;    // 当前指针的next指向前一个，链表指针反转
            pre = curr;     // pre和curr指针向后推进
            curr = nextTemp;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void test() {
        ListNode l1_4 = new ListNode(18);
        ListNode l1_3 = new ListNode(9, l1_4);
        ListNode l1_2 = new ListNode(6, l1_3);
        ListNode l1_1 = new ListNode(7, l1_2);

        ListNode result = reverseList(l1_1);
        ListNode a = result;
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }


}
