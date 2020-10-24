package com.chen.algorithm.znn.linkedlist.test141;

import com.chen.algorithm.znn.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: zhunn
 * @Date: 2020/10/23 16:26
 * @Description: 环形链表一：判断链表是否有环
 * 方法：1-哈希表，2-快慢指针
 */
public class Solution {

    /**
     * 2-快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1-哈希表
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode dummy = head;
        Set<ListNode> visited = new HashSet<>();
        while (dummy != null) {
            if (visited.contains(dummy)) {
                return true;
            } else {
                visited.add(dummy);
            }
            dummy = dummy.next;
        }
        return false;
    }

    /**
     * 1-哈希表简易版
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
