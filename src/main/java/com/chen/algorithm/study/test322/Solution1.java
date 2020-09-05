package com.chen.algorithm.study.test322;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-09-05 15:09
 */
public class Solution1 {


    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

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
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }


}
