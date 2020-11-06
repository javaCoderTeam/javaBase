package com.chen.algorithm.znn.dynamic.test62;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/11/5 16:05
 * @Description: 不同路径：1-动态规划
 * 返回共有几条路径
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        //if (m == 1 || n == 1) {
        //    return 1;
        //}

        int[][] dp = new int[m][n];     //定义状态转移方程
        for (int i = 0; i < m; i++) {   //边界初始化
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(7, 3));
    }
}
