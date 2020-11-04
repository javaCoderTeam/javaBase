package com.chen.algorithm.znn.dynamic.test714;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/dong-tai-gui-hua-by-liweiwei1419-6/
 * @Auther: zhunn
 * @Date: 2020/11/3 22:04
 * @Description: 买卖股票的最佳时机含手续费：1-动态规划，2-动态规划-优化空间
 * 注意：人为规定在买入股票的时候扣除手续费
 */
public class Solution {

    /**
     * 1-动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益'
        // j = 0 表示不持股，j = 1 表示持股
        // 并且规定在买入股票的时候，扣除手续费

        int len = prices.length;
        int[][] dp = new int[len][2]; // 定义状态转移方程
        // 初始化值
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[len - 1][0];
    }

    /**
     * 2-动态规划-优化空间
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int len = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0] - fee;
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i] - fee);
        }
        return dp[0];
    }

    @Test
    public void test() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit2(prices, fee));
    }
}
