package com.chen.algorithm.znn.linkedlist.test19;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @Auther: zhunn
 * @Date: 2020/10/22 14:51
 * @Description: 删除链表的倒数第N个节点 1、遍历length-n+1；2、栈、3、双指针法（推荐）
 */
public class Solution {

    /**
     * 计算链表长度并遍历
     *
     * @param head 头结点
     * @param n    删除倒数第几个
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        int len = getLength(head);
        for (int i = 1; i < len - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }

    /**
     * 用stack
     *
     * @param head 头结点
     * @param n    删除倒数第几个
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode curr = dummy;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 双指针法 （推荐）
     *
     * @param head 头结点
     * @param n    删除倒数第几个
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode lenNode = head;
        int len = 0;
        while (lenNode != null) {
            len++;
            lenNode = lenNode.next;
        }
        return len;
    }

    @Test
    public void test() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);

        ListNode result = removeNthFromEnd3(head, 2);

        ListNode a = result;
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
        //System.out.println(result);
    }
}
