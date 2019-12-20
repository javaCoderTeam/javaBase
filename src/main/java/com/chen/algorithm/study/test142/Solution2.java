package com.chen.algorithm.study.test142;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :  chen weijie
 * @Date: 2019-12-05 00:16
 */
public class Solution2 {


    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {

            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }


}
