package com.chen.algorithm.study.test674;

/**
 * @author :  chen weijie
 * @Date: 2020-05-24 00:15
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
