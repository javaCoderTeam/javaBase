package com.chen.algorithm.study.test188;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/dong-tai-gui-hua-by-liweiwei1419-4/
 *
 * @author :  chen weijie
 * @Date: 2020-09-06 01:37
 */
public class Solution {


    public int maxProfit(int k, int[] prices) {

        int len = prices.length;
        // 特判
        if (k == 0 || len < 2) {
            return 0;
        }
        if (k >= len / 2) {
            return greedy(prices, len);
        }

        // dp[i][j][K]：到下标为 i 的天数为止（从 0 开始），到下标为 j 的交易次数（从 0 开始）
        // 状态为 K 的最大利润，K = 0 表示不持股，K = 1 表示持股
        int[][][] dp = new int[len][k][2];

        // 初始化：把持股的部分都设置为一个较大的负值
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }


        for (int i = 0; i < len; i++) {

            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j][1] = -prices[i];
                    dp[i][j][0] = 0;
                } else {
                    if (j == 0) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                    } else {
                        // 基本状态转移方程 1。
                        //分类讨论的依据依然是：昨天是否持股。
                        //
                        //（1）昨天持股，今天还持股，说明没有发生新的交易，这两天在同一个交易区间里；
                        //（2）昨天不持股，今天持股，说明开启了一次新的交易。
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                    // 基本状态转移方程 2

                    //分类讨论的依据是：昨天是否持股。
                    //（1）昨天不持股，今天还不持股，说明没有发生新的交易；
                    //（2）昨天持股，今天不持股，说明这次交易结束了。这两种情况都在一次交易里。

                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                }
            }
        }
        // 说明：i、j 状态都是前缀性质的，只需返回最后一个状态
        return dp[len - 1][k - 1][0];
    }


    private int greedy(int[] prices, int len) {
        // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }


}
