package com.chen.algorithm.znn.linkedlist.test92;

import com.chen.algorithm.znn.linkedlist.ListNode;
import com.chen.api.util.thread.study.chapter2.t6.CommonUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @Auther: zhunn
 * @Date: 2020/10/24 17:23
 * @Description: 反转链表二：1-双指针，2-双指针头插法-删除结点递推(推荐)
 */
public class Solution {

    // 翻转n个节点，返回新链表的头部
    private ListNode reverseN(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }
        return prev;
    }

    /**
     * 1-双指针
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(42);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;
        // 找到左右两段的端点
        for (int i = 0; i < m - 1; i++) {
            ptr2 = ptr2.next;
        }
        for (int i = 0; i < n + 1; i++) {
            ptr1 = ptr1.next;
        }
        // 找到中段的尾端点
        ListNode t = ptr2.next;
        // 翻转中段，得到中段的头端点
        ListNode h = reverseN(t, n - m + 1);
        // 中端的头端点和左段端点相连
        ptr2.next = h;
        // 中段的尾端点和右段端点相连
        t.next = ptr1;
        return dummy.next;
    }

    /**
     * 2-删除结点递推 (推荐)
     * curr后面的元素删除，然后添加到pre的后面。也即头插法
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode curr = dummy.next;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            curr = curr.next;   //将curr移动到第一个要反转的节点的位置上
        }

        for (int i = m; i < n; i++) {
            ListNode removeNode = curr.next;
            curr.next = curr.next.next;  // 删除head后面的元素

            removeNode.next = pre.next;   // head后面的元素添加到pre后面
            pre.next = removeNode;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(7);
        ListNode l1_2 = new ListNode(9);
        ListNode l1_3 = new ListNode(2);
        ListNode l1_4 = new ListNode(10);
        ListNode l1_5 = new ListNode(1);
        ListNode l1_6 = new ListNode(8);
        ListNode l1_7 = new ListNode(6);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = l1_6;
        l1_6.next = l1_7;

        ListNode result = reverseBetween(l1_1, 3, 6);

        ListNode a = result;
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
        System.out.println();
    }
}
