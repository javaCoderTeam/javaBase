package com.chen.algorithm.znn.dynamic.test64;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 *
 * @Auther: zhunn
 * @Date: 2020/11/5 11:33
 * @Description: 最小路径和：1-动态规划；2-动态规划-优化空间，使用原数组空间；3-动态规划-优化空间，不更改原数组(可忽略)
 */
public class Solution {

    /**
     * 1-动态规划，官方解答
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols]; // dp[i][j],i表示行，j表示列
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 2-动态规划-优化空间，使用原数组空间
     *
     * @return
     */
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        //int[][] dp = new int[rows][cols]; // dp[i][j],i表示行，j表示列
        //dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[rows - 1][cols - 1];
    }

    /**
     * 3-动态规划-优化空间，不更改原数组
     *
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid) {
        int len = grid[0].length;
        int[] dp = new int[len];
        dp[0] = grid[0][0];
        for (int i = 1; i < len; i++)
            dp[i] = dp[i - 1] + grid[0][i];
        for (int i = 1; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < len; j++)
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
        }
        return dp[len - 1];
    }

    @Test
    public void testCase() {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(minPathSum2(nums));
    }
}
