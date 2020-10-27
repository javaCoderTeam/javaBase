package com.chen.algorithm.znn.stack.test239;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Auther: zhunn
 * @Date: 2020/10/27 14:32
 * @Description: 滑动窗口最大值
 */
public class Solution {


    /**
     * 采用双端队列存储数组值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] res = new int[nums.length - k + 1];
        // 递减队列
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // 添加滑入的数 nums[i] ，构造递减队列
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);

            // 删除滑出的数 nums[i - k]，如果删除的数等于队头，删除队头
            if (i >= k && nums[i - k] == queue.peekFirst()) {
                queue.pollFirst();
            }

            // 写入当前最大值
            if (i >= k - 1) {
                res[i - k + 1] = queue.peekFirst();
            }
        }
        return res;
    }

    /**
     * 采用双端队列存储数组下标
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void testCase() {

        int[] nums = {1, 3, -1, -3, 5, 3, 2, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow2(nums, k)));
    }
}
