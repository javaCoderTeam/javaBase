package com.chen.algorithm.study.test234;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/solution/ji-bai-liao-bai-fen-zhi-97de-javayong-hu-by-reedfa/
 *
 * @author :  chen weijie
 * @Date: 2019-11-03 17:58
 */
public class Solution1 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // 快慢指针找到链表的中点
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转链表的前半部分,从上述的算数中，中点此时为slow；
        ListNode pre = null;
        while (head != slow) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        //如果是奇数个节点，去掉后半部分的第一个节点。
        if (fast != null) {
            slow = slow.next;
        }

        // 回文校验
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

}
