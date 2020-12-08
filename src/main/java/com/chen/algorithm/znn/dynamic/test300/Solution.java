package com.chen.algorithm.znn.dynamic.test300;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * @Auther: zhunn
 * @Date: 2020/11/4 21:03
 * @Description: 最长上升子序列：1-动态规划（推荐）；2-动态规划-优化空间（贪心+二分查找）
 */
public class Solution {

    /**
     * 1-动态规划（推荐）
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len]; // dp[i]标识以nums[i]结尾的[上升子序列]的长度
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 8, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
