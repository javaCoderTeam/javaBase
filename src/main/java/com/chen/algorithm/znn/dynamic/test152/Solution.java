package com.chen.algorithm.znn.dynamic.test152;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/
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
