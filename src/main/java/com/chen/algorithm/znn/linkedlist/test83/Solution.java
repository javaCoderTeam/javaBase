package com.chen.algorithm.znn.linkedlist.test83;

import com.chen.algorithm.znn.linkedlist.ListNode;
import org.junit.Test;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @Author: zhunn
 * @Date: 2020-10-08 02:19
 * @Description: 删除排序链表中的重复元素：同删除排序数组中的重复元素
 */
public class Solution {


    /**
     * 需要注意的点，
     * 1、应该是后面节点和前面节点比较；
     * 2、如果后面节点和前面节点的值一致，则只是修改前节点的指针，遍历指针不前进
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode five = new ListNode(3);
        ListNode four = new ListNode(3, five);
        ListNode three = new ListNode(2, four);
        ListNode two = new ListNode(1, three);
        ListNode head = new ListNode(1, two);

        ListNode result = deleteDuplicates(head);

        ListNode a = result;
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
        //System.out.println(result);
    }

}
