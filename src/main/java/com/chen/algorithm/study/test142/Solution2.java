package com.chen.algorithm.study.test142;

/**
 * @author :  chen weijie
 * @Date: 2019-12-05 00:16
 */
public class Solution2 {


    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }
        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public ListNode detectCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (true){
            if (fast == null ||fast.next == null){
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }







}
