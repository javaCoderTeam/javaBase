package com.chen.algorithm.mergeArray;


/**
 * 合并两个有序链表
 *
 * @author :  chen weijie
 * @Date: 2020-05-01 23:39
 */
public class MergeTowLinkList {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {

            if (l1.val >= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 != null) {
            prev.next = l1;
        }

        if (l2 != null) {
            prev.next = l2;
        }
        return preHead.next;
    }


}
