package com.chen.algorithm.study.test322;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 *
 * @author :  chen weijie
 * @Date: 2020-05-24 00:43
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    @Test
    public void testCase() {
        int[] coins = {2};
        System.out.println(coinChange(coins, 3));
    }


}
