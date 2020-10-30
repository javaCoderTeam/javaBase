package com.chen.algorithm.znn.tree.test96;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 17:49
 * @Description: 不同的二叉搜索树：1-动态规划
 */
public class Solution {

    /**
     * 1-动态规划 求G(n)
     * G(0) = 1，G(1) = 1
     * G(n) = G(i-1)*G(n-i) 求和（1<= i <=n）
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
