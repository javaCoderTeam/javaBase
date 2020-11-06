package com.chen.algorithm.znn.dynamic.test198;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
 *
 * @Auther: zhunn
 * @Date: 2020/11/6 17:16
 * @Description: 打家劫舍：1-动态规划；2-动态规划 + 滚动数组
 */
public class Solution {

    /**
     * 1-动态规划
     * 1. 偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
     * 2. 不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];    // dp[i] 表示前 ii 间房屋能偷窃到的最高总金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], temp);
            first = temp;
        }
        return second;
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob2(nums));
    }
}
