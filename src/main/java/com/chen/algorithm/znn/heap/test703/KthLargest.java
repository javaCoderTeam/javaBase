package com.chen.algorithm.znn.heap.test703;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 返回当前数据流中第 k 大的元素。
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * @Auther: zhunn
 * @Date: 2020/10/26 16:55
 * @Description: 求数组中的第K个最大元素：1-暴力；2-优先级队列
 */
public class KthLargest {

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
            queue.add(num);
        } else if (queue.peek() < num) {
            queue.poll();
            queue.add(num);
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargest kthLargest = new KthLargest(3, n);
        System.out.println(kthLargest.add(3));
    }
}
