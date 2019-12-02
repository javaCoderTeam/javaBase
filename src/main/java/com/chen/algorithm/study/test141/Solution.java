package com.chen.algorithm.study.test141;

import java.util.*;

/**
 * @author :  chen weijie
 * @Date: 2019-11-02 15:58
 */
public class Solution {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();

        int n = 0;
        while (head != null) {
            if (map.containsValue(head)) {
                return true;
            } else {
                map.put(n, head);
                n++;
                head = head.next;
            }
        }
        return false;
    }


}

