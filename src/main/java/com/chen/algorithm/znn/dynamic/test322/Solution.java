package com.chen.algorithm.znn.dynamic.test322;

import org.junit.Test;

import java.util.Arrays;


/**
 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * 官方解答：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * @Auther: zhunn
 * @Date: 2020/11/4 22:03
 * @Description: 零钱兑换：1-动态规划；2-动态规划-优化空间
 * 返回所需的最少的硬币个数
 */
public class Solution {

    /**
     * 动态规划-优化空间（推荐）
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            if(amount == 0){
                return 0;
            }
            return -1;
        }

        int[] dp = new int[amount + 1];     // 状态转移方程-凑成amount数值需要的最少硬币数，给 0 占位
        Arrays.fill(dp, amount + 1);    // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
        dp[0] = 0;          // 理解 dp[0] = 0 的合理性，单独一枚硬币如果能够凑出面值，符合最优子结构

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 5};
        int amount = 10;
        System.out.println(coinChange(nums, amount));
    }
}
