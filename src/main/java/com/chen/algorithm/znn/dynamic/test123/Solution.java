package com.chen.algorithm.znn.dynamic.test123;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 21:06
 * @Description: 买卖股票的最佳时机 III：1-动态规划-优化空间；2-动态规划
 */
public class Solution {

    /**
     * 1-动态规划-优化空间
     * (由于今天只参考了昨天的状态，所以直接去掉第一维度不会影响状态转移的正确性)
     *
     * @param prices
     * @return dp[i][j][k]: i 表示第几天（0-n），j表示交易了几次（0,1,2），k表示是否持股（0-不持股,1-持股）
     * 此题可以用dp[j][k] 即可
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[3][2];
        dp[0][0] = 0;
        dp[1][1] = -prices[0];
        dp[2][1] = Integer.MIN_VALUE; // 还没发生的交易，持股的时候应该初始化为负无穷

        for (int i = 1; i < prices.length; i++) {
            dp[1][1] = Math.max(-prices[i], dp[1][1]);
            dp[1][0] = Math.max(dp[1][1] + prices[i], dp[1][0]);
            dp[2][1] = Math.max(dp[1][0] - prices[i], dp[2][1]);
            dp[2][0] = Math.max(dp[2][1] + prices[i], dp[2][0]);
        }
        return Math.max(dp[1][0], dp[2][0]);
    }

    /**
     * 2-动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        int n = prices.length;
        int[][] dp = new int[n][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 0; i < n; i++) {
            dp[i][3] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][2]), dp[n - 1][4]);
    }

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit2(prices));
    }
}
