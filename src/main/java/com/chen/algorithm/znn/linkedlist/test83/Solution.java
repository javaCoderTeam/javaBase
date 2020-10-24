package com.chen.algorithm.znn.linkedlist.test83;

import com.chen.algorithm.znn.linkedlist.ListNode;

/**
 * @Author: zhunn
 * @Date: 2020-10-08 02:19
 * @Description: 删除排序链表中的重复元素
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


}
