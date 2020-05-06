package com.chen.algorithm.dynamicprogramming;

/**
 * 最短路径问题，
 * 使用动态规划的
 *
 * @author :  chen weijie
 * @Date: 2020-05-01 22:25
 */
public class MinDistDP {


    /**
     * 状态转移表法表 来解决问题
     * @param matrix
     * @param n
     * @return
     */
    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        // 初始化states的第一行数据
        for (int j = 0; j < n; ++j) {
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        // 初始化states的第一列数据
        for (int i = 0; i < n; ++i) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }


    private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    private int n = 4;
    private int[][] mem = new int[4][4];


    /**
     * 状态转移方程来解决问题
     *
     * @param i
     * @param j
     * @return
     */
    public int minDist(int i, int j) { // 调用minDist(n-1, n-1);
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }

        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }


}
