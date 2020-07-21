package com.chen.algorithm.study.test160;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 14:42
 */
public class Solution1 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // 每个指针都走过两个链表，要么都相等等于相交节点，要么走到最后都是null
        while (pA != pB) {
            if (pA == null) {
                // 指针直接指向另一个链表，不是next指向另一个链表。因为此时pA已经是null
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB != null) {
                pB = pB.next;
            } else {
                pB = headA;
            }
        }
        return pB;
    }


}
