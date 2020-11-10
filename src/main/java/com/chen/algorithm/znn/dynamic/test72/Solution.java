package com.chen.algorithm.znn.dynamic.test72;

import org.junit.Test;

/**
 * 官方：https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
 * https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @Auther: zhunn
 * @Date: 2020/11/5 15:09
 * @Description: 编辑距离：1-动态规划
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1 == null ? 0 : word1.length();
        int n = word2 == null ? 0 : word2.length();
        if (m == 0 || n == 0) {   // m*n == 0,有一个字符串为空串
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];    // 多开一行一列是为了保存边界条件，即字符长度为 0 的情况，这一点在字符串的动态规划问题中比较常见
        for (int i = 0; i < m + 1; i++) {     // 边界状态初始化：当 word 2 长度为 0 时，将 word1 的全部删除
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {    // 当 word1 长度为 0 时，就插入所有 word2 的字符
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        System.out.println(minDistance("horse", "ros"));
    }


}
