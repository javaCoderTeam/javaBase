package com.chen.algorithm.znn.dynamic.test279;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/11/5 18:00
 * @Description: 完全平方数：1-动态规划
 */
public class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        //dp[0] = 0;  //题意是给定正整数，不用考虑0

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numSquares(9));
    }
}
