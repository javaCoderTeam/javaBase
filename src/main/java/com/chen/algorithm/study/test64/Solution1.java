package com.chen.algorithm.study.test64;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 *
 * @author :  chen weijie
 * @Date: 2020-05-13 00:02
 */
public class Solution1 {

    public int minPathSum(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int clomn = grid[0].length;

//        int[][] grid = new int[row][clomn];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clomn; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[row - 1][clomn - 1];
    }

    @Test
    public void testCase() {

        int[][] nums = {{4, 5, 6}, {5, 6, 7}, {52, 4, 5}};


    }


}
