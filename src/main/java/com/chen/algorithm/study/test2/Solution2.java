package com.chen.algorithm.study.test2;

/**
 * @author :  chen weijie
 * @Date: 2019-09-07 16:16
 */
public class Solution2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummmy = new ListNode(-1);
        ListNode curr = dummmy;

        int sum = 0;
        ListNode p1 = l1,p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum /= 10;
        }

        if (sum == 1) {
            curr.next = new ListNode(sum);
        }
        return dummmy.next;
    }




}
