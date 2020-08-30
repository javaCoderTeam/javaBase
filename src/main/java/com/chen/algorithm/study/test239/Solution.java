package com.chen.algorithm.study.test239;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-3/
 * @author :  chen weijie
 * @Date: 2020-08-30 01:29
 */
public class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {

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

    @Test
    public void testCase() {

        int[] nums = {1, 3, -1, -3, 5, 3, 2, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));


    }


}
