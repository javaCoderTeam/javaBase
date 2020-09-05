package com.chen.algorithm.study.test309;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
 *
 * @author :  chen weijie
 * @Date: 2020-04-12 17:53
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][3];
//      不持股可以由这两个状态转换而来：
//          昨天不持股，今天什么都不操作，仍然不持股；
//          昨天持股，今天卖了一股。
//      持股可以由这两个状态转换而来：
//          昨天持股，今天什么都不操作，仍然持股；
//          昨天处在冷冻期，今天买了一股；
//      处在冷冻期只可以由不持股转换而来，因为题目中说，刚刚把股票卖了，需要冷冻 1 天。

        // 初始化
//        0 表示不持股；
//        1 表示持股；
//        2 表示处在冷冻期。
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i-1][0];
        }

        return Math.max(dp[len - 1][2], dp[len - 1][0]);
    }

}
