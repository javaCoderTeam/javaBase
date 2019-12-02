package com.chen.algorithm.study.test198;

/**
 * @author :  chen weijie
 * @Date: 2019-11-02 18:43
 */
public class Solution {


    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }


}
