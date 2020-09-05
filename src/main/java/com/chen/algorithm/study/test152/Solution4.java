package com.chen.algorithm.study.test152;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-09-04 18:35
 */
public class Solution4 {


//    5 3 -2 10

    public int maxProduct(int[] nums) {

        int[][] dp = new int[nums.length + 1][2];

        dp[0][1] = nums[0];
        dp[0][0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currVal = nums[i];
            if (currVal > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * currVal, currVal);
                dp[i][1] = Math.min(dp[i - 1][1] * currVal, currVal);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * currVal, currVal);
                dp[i][1] = Math.min(dp[i - 1][0] * currVal, currVal);
            }
            max = Math.max(dp[i][0], max);
        }
        return max;
    }


    @Test
    public void testCase() {

        int[] nums = {5, 3, -2, 10};
        System.out.println(maxProduct(nums));
    }


}
