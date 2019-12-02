package com.chen.algorithm.study.test19;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-10 00:54
 */
public class Solution1 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        System.out.println("first====" + (head == dummy.next));

        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
            System.out.println("i===" + (head == dummy.next));
        }

        while (first != null) {
            System.out.println("n===" + (head == dummy.next));
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        System.out.println(head);
        System.out.println(dummy.next);
        System.out.println(head.val);

//        System.out.println("last====" + (head == dummy.next));
        return dummy.next;
    }


    @Test
    public void testCase() {


        ListNode head = new ListNode(1);

        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;


        ListNode nextNode = new ListNode(1);
//        head.next = nextNode;


//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        System.out.println(head == dummy.next);

        System.out.println(System.identityHashCode(removeNthFromEnd(nextNode, 1)));
//        System.out.println(System.identityHashCode(dummy.next));
//        System.out.println(System.identityHashCode(dummy));


    }


}
