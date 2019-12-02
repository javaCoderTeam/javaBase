package com.chen.algorithm.study.test234;

/**
 * @author :  chen weijie
 * @Date: 2019-11-03 17:58
 */
public class Solution {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        ListNode p1 = head;
        int size = 0;
        for (int i = 1; p1 != null; p1 = p1.next, i++) {
            size = i;
        }

        int[] a = new int[size];

        for (int i = 0; head != null; head = head.next, i++) {
            a[i] = head.val;
        }

        int j = size;

        for (int i = 0; i < size / 2; i++, j--) {
            if (a[i] != a[j - 1]) {
                return false;
            }
        }

        return true;
    }

}
