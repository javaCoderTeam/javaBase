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

        // 终止条件两个不相等
        while (pA != pB) {
            if (pA == null) {
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
