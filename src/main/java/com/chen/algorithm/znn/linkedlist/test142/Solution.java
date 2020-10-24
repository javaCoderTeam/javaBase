package com.chen.algorithm.znn.linkedlist.test142;


import com.chen.algorithm.znn.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: zhunn
 * @Date: 2020/10/23 16:10
 * @Description: 环形链表二，找出入环点
 * 方法：1-哈希表，2-快慢指针
 */
public class Solution {

    /**
     * 1-哈希表
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = head;
        Set<ListNode> visited = new HashSet<>();
        while (dummy != null) {
            if (visited.contains(dummy)) {
                return dummy;
            } else {
                visited.add(dummy);
            }
            dummy = dummy.next;
        }
        return null;
    }

    /**
     * 2-快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        ListNode ptr = head;
        while (slow != ptr) {
            slow = slow.next;
            ptr = ptr.next;
        }
        return slow;
    }

}
