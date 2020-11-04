package com.chen.algorithm.znn.dynamic.test188;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/dong-tai-gui-hua-by-liweiwei1419-4/
 * @Auther: zhunn
 * @Date: 2020/11/3 22:03
 * @Description: 买卖股票的最佳时机 IV :1-动态规划-三维超出内存限制；2-动态规划-优化空间，降维，使用二维
 * <p>
 * 理解状态转移方程：
 * 人为规定：如果当天买入股票的时候记录「交易发生一次」，如果当天卖出股票，不增加交易次数；
 * 买入股票，手上持有的现金数减少（减去当天股价），相应地，卖出股票，手上持有的现金数增加（加上当天股价）；
 * 难点：还没发生的交易，并且还规定了当天必须持股的状态值应该设置为负无穷
 */
public class Solution {

    // 超出内存限制
    //public int maxProfit(int k, int[] prices) {
    //    int len = prices.length;
    //    // 特殊判断
    //    if (k == 0 || len < 2) {
    //        return 0;
    //    }
    //    // 特殊判断，因为交易一次需要 2 天，如果 k >= len / 2，相当于没有限制
    //    // 转换为「力扣」第 122 题，使用贪心算法
    //    if (k >= len / 2) {
    //        return greedy(prices, len);
    //    }
    //
    //    // 状态转移方程里下标有 -1 的时候，为了防止数组下标越界，多开一行，因此第一维的长度是 len + 1
    //    // 第二维表示交易次数，从 0 开始，因此第二维的长度是 k + 1
    //    // 第三维表示是否持股，0：不持股，1：持股
    //    int[][][] dp = new int[len + 1][k + 1][2];
    //
    //    // 初始化：把持股的部分都设置为一个较小的负值
    //    // 注意：如果使用默认值 0，状态转移的过程中会做出错误的决策
    //    for (int i = 0; i <= len; i++) {
    //        for (int j = 0; j <= k; j++) {
    //            dp[i][j][1] = Integer.MIN_VALUE;
    //        }
    //    }
    //
    //    // 注意：i 和 j 都有 1 个位置的偏移
    //    for (int i = 1; i <= len; i++) {
    //        for (int j = 1; j <= k; j++) {
    //            dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
    //            dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
    //        }
    //    }
    //    // 说明：第一维和第二维状态都具有前缀性质的，输出最后一个状态即可
    //    return dp[len][k][0];
    //}
    //private int greedy(int[] prices, int len) {
    //    // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
    //    int res = 0;
    //    for (int i = 1; i < len; i++) {
    //        if (prices[i] > prices[i - 1]) {
    //            res += prices[i] - prices[i - 1];
    //        }
    //    }
    //    return res;
    //}

    /**
     * 1-动态规划-三维超出内存限制
     *
     * @param prices
     * @param k
     * @return
     */
    public int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len / 2) {
            return greedy(prices);
        }

        int[][][] dp = new int[len + 1][k + 1][2];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        // 注意：i 和 j 都有 1 个位置的偏移
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }


        return dp[len][k][0];
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

    /**
     * 2-动态规划-优化空间，降维，使用二维
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices, int k) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len / 2) {
            return greedy(prices);
        }

        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + price);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
            }
        }
        return dp[k][0];
    }

    @Test
    public void test() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit2(prices, 2));
    }
}
