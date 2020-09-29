package com.chen.algorithm.study.test279;

/**
 * @author :  chen weijie
 * @Date: 2019-12-22 15:13
 */
public class Solution {


    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];

    }

}
