package com.chen.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-04-15 23:18
 */
public class Solution {


    public List<Integer> outList(ListNode node) {

        if (node == null) {
            return new ArrayList<>();
        }

        ListNode head = node;
        ListNode current = node.next;

        while (current != null) {
            ListNode temp = current.next;
            current.next = head;
            head = current;
            current = temp;
        }

        node.next = null;

        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }




}
