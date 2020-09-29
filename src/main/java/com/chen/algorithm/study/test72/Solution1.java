package com.chen.algorithm.study.test72;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
 *
 * @author :  chen weijie
 * @Date: 2020-05-17 13:32
 */
public class Solution1 {


    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }


    @Test
    public void testCase() {

        System.out.println(minDistance("horse", "ros"));
    }


}
