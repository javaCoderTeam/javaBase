package com.chen.algorithm.znn.stack.test703;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 16:55
 * @Description: 求数组中的第K个最大元素：1-暴力；2-优先级队列
 */
public class Solution {

    class KthLargest {
        private PriorityQueue<Integer> queue;
        private int limit;

        public KthLargest(int size, int[] nums) {
            this.limit = size;
            queue = new PriorityQueue<>(limit);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int num) {

            if (queue.size() < limit) {
                queue.offer(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }

            return queue.peek();
        }
    }


    @Test
    public void testCase() {
        int[] n = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargest kthLargest = new KthLargest(2, n);
        System.out.println(kthLargest.add(3));

    }
}
