package com.chen.algorithm.znn.linkedlist.test142;


import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * @Auther: zhunn
 * @Date: 2020/10/23 16:10
 * @Description: 环形链表二，找出入环点
 * 方法：1-哈希表，2-快慢指针(推荐)
 */
public class Solution {

    /**
     * 1-哈希表
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
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
     *
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

    @Test
    public void test() {
        ListNode l1_1 = new ListNode(6);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(8);
        ListNode l1_4 = new ListNode(7);
        ListNode l1_5 = new ListNode(5);

        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = l1_3;

        ListNode result = detectCycle2(l1_1);
        System.out.println(result.val);
    }
}
