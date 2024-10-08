package com.chen.algorithm.study.test206;

/**
 * @author :  chen weijie
 * @Date: 2019-09-08 01:38
 */
public class SolutionTest {


    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(6);
        ListNode l1_3 = new ListNode(10);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode result = reverseList(l1_1);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
