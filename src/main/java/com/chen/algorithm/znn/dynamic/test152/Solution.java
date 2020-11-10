package com.chen.algorithm.znn.dynamic.test152;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 22:02
 * @Description: 乘积最大子数组：1-动态规划；2-动态规划-优化空间
 */
public class Solution {

    /**
     * 1-动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最大值
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
        }

        // 只关心最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(dp[i][1], res);
        }
        return res;
    }

    /**
     * 2-动态规划-优化空间
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = nums[0];
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            int min = dp[0], max = dp[1];

            dp[0] = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            dp[1] = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            res = Math.max(res, dp[1]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct2(nums));
    }
}
