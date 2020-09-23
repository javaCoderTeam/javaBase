package com.chen.algorithm.study.test188;

/**
 * @author :  chen weijie
 * @Date: 2020-09-22 00:08
 */
public class Solution1 {

    public int maxProfit(int k, int[] prices) {

        if (prices.length < 2 || k == 0) {
            return 0;
        }

        int length = prices.length;

        if (k >= length / 2) {
            return greedy(prices);
        }


        int[][][] dp = new int[length][k][2];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    if (j == 0) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                    } else {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                }
            }
        }

        return dp[length - 1][k - 1][0];
    }

    private int greedy(int[] prices) {
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
