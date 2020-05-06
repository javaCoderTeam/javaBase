package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-28 18:37
 */
public class TestRevertLinkList {


    public static class ListNode {

        private int value;

        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }


    @Test
    public ListNode solution() {


        ListNode head = new ListNode(3);

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

}
