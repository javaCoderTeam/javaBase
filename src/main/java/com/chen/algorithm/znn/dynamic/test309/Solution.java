package com.chen.algorithm.znn.dynamic.test309;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 22:03
 * @Description: 最佳买卖股票时机含冷冻期：1-动态规划；2-动态规划-优化空间
 */
public class Solution {

    /**
     * 1-动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        // dp[i][0]: 手上不持有股票，并且今天不是由于卖出股票而不持股，我们拥有的现金数
        // dp[i][1]: 手上持有股票时，我们拥有的现金数
        // dp[i][2]: 手上不持有股票，并且今天是由于卖出股票而不持股，我们拥有的现金数
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    /**
     * 2-动态规划-优化空间
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[3];

        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;

        int pre0 = dp[0];
        int pre2 = dp[2];

        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], pre2);
            dp[1] = Math.max(dp[1], pre0 - prices[i]);
            dp[2] = dp[1] + prices[i];

            pre0 = dp[0];
            pre2 = dp[2];
        }
        return Math.max(dp[0], dp[2]);
    }

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
