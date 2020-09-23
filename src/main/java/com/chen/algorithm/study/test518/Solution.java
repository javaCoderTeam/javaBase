package com.chen.algorithm.study.test518;

/**
 * https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
 *
 * @author :  chen weijie
 * @Date: 2020-09-22 01:10
 */
public class Solution {


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) { //枚举硬币
            for (int i = 1; i <= amount; i++) {  //枚举金额
                if (i < coin) {
                    continue; // coin不能大于amount
                }
                dp[i] = dp[i - coin] + dp[i];
            }
        }
        return dp[amount];


    }
}
