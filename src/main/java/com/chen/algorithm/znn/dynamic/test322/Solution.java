package com.chen.algorithm.znn.dynamic.test322;

import org.junit.Test;

import java.util.Arrays;


/**
 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * 官方解答：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 *
 * @Auther: zhunn
 * @Date: 2020/11/4 22:03
 * @Description: 零钱兑换：1-动态规划；2-动态规划-优化空间
 * 返回所需的最少的硬币个数
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int max = amount + 1;
        int[] dp = new int[amount + 1]; // 给 0 占位
        Arrays.fill(dp, max);  // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值

        dp[0] = 0;  // 理解 dp[0] = 0 的合理性，单独一枚硬币如果能够凑出面值，符合最优子结构
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
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
