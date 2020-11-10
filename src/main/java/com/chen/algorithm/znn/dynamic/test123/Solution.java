package com.chen.algorithm.znn.dynamic.test123;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
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
