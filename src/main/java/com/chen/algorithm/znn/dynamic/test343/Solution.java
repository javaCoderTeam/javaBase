package com.chen.algorithm.znn.dynamic.test343;

import org.junit.Test;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * @Auther: zhunn
 * @Date: 2020/11/5 18:46
 * @Description: 整数拆分
 */
public class Solution {

    public int integerBreak(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];  // dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
                // 将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }


    @Test
    public void test() {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(58));
    }
}
