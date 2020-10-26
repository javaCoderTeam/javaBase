package com.chen.algorithm.znn.heap.test215;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 16:55
 * @Description: 求数组中的第K个最大元素：1-暴力；2-优先级队列
 */
public class Solution {

    public int findKthLargest1(int[] nums, int k) {
        //if (nums == null || k > nums.length) {
        //    return -1;
        //}

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums[k - 1];
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }


    @Test
    public void testCase() {
        int[] n = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(n, 2));

    }
}
