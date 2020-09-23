package com.chen.algorithm.study.test309;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
 *
 * @author :  chen weijie
 * @Date: 2020-04-12 17:53
 */
public class Solution1 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];
        }

        return Math.max(dp[length - 1][0], dp[length - 1][2]);
    }

}
