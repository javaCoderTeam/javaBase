package com.chen.algorithm.znn.linkedlist.test160;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * @Author: zhunn
 * @Date: 2020-10-22 17:40
 * @Description: 相交链表：双指针法
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(6);
        ListNode l1_2 = new ListNode(1);
        ListNode l1_3 = new ListNode(8);
        ListNode l1_4 = new ListNode(7);
        ListNode l1_5 = new ListNode(5);

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(0);
        ListNode l2_3 = new ListNode(1);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l1_3;

        ListNode result = getIntersectionNode(l1_1, l2_1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
