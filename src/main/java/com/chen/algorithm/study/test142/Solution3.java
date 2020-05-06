package com.chen.algorithm.study.test142;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 15:47
 */
public class Solution3 {


    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true){

            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast){
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


}
