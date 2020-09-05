package com.chen.algorithm.study.test300;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-09-05 11:27
 */
public class Solution1 {


    /**
     * 10 9 2 5 3 7 101 18
     *
     * @param nums
     * @return
     */
    public int lengthOfList(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length - 1];

        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            max = Math.max(dp[i], max);
        }
        return max;
    }
}
