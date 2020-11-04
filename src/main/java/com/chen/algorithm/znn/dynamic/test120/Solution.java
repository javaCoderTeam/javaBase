package com.chen.algorithm.znn.dynamic.test120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 22:02
 * @Description: 三角形最小路径和:1-动态规划；2-动态规划-空间优化（推荐）
 * 第i行的列数等于 i+1，即行数加一
 */
public class Solution {

    /**
     * 1-动态规划：时间和空间复杂度都是O(n^2)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size(); // 总行数
        int m = triangle.get(n - 1).size(); // 总列数
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。 由于存储最高层的数据，所以需要数值上加1

        for (int i = n - 1; i >= 0; i--) { // 从三角形的最后一行开始递推。
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    /**
     * 2-动态规划-空间优化（推荐）：时间复杂度O(n^2)、空间复杂度是O(n)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[] dp = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    @Test
    public void testCase() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal2(triangle));

    }
}
