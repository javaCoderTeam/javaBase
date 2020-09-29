package com.chen.algorithm.study.test343;

/**
 * @author :  chen weijie
 * @Date: 2020-09-17 01:12
 */
public class Solution1 {


    public int integerBreak(int n) {

        int[] dp = new int[n + 1];


        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(dp[i - j] * j, j * (i - j)));
            }
            dp[i] = curMax;
        }


        return dp[n];
    }
}
