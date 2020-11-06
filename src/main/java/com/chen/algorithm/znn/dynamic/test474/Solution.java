package com.chen.algorithm.znn.dynamic.test474;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/
 *
 * @Auther: zhunn
 * @Date: 2020/11/6 14:54
 * @Description: 一和零：1-动态规划，0-1背包问题；2-动态规划优化空间（滚动数组，从后往前）
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }

    public int[] countzeroesones(String s) {
        int[] cnt = new int[2];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }
        return cnt;
    }

    /**
     * 1-动态规划，0-1背包问题
     * 定义状态：尝试题目问啥，就把啥定义成状态。dp[i][j][k] 表示输入字符串在子区间 [0, i] 能够使用 j 个 0 和 k 个 1 的字符串的最大数量。
     *
     * @param strs
     * @param m    0的个数
     * @param n    1的个数
     * @return
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            int[] cnt = countzeroesones(strs[i - 1]);  // 注意：有一位偏移
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];    // 先把上一行抄下来

                    if (j >= cnt[0] && k >= cnt[1]) {   // 超过最大0和1的限制，不选此字符串
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[0]][k - cnt[1]] + 1); // dp[i - 1][j][k],不选；dp[i][j - cnt[0]][k - cnt[1]] + 1，选
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    /**
     * 2-动态规划优化空间（滚动数组，从后往前）
     *
     * @param strs
     * @param m    0的个数
     * @param n    1的个数
     * @return
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        //dp[0][0] = 0;

        for (String str : strs) {
            int[] cnt = countzeroesones(str);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cnt[0]][j - cnt[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm2(strs, 5, 3));
    }
}
