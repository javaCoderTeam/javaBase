package com.chen.algorithm.znn.dynamic.test518;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
 * https://leetcode-cn.com/problems/coin-change-2/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-liweiw/
 * 官方解答：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode/
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 * @Auther: zhunn
 * @Date: 2020/11/5 9:52
 * @Description: 零钱兑换 II：1-动态规划
 * 返回所有组合数
 * 组合问题，交换循环顺序就是排列问题（爬楼梯）
 */
public class Solution {

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1; // amount=0时，有一种组合 0

        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] = dp[x] + dp[x - coin];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) { // 枚举硬币
            for (int x = 1; x <= amount; x++) { // 枚举金额
                if (coin > x) {
                    continue; // coin不能大于金额
                }
                dp[x] = dp[x] + dp[x - coin];
            }
        }
        return dp[amount];
    }

    @Test
    public void test() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change2(amount, coins));
    }
}
