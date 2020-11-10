package com.chen.algorithm.znn.array.test240;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/er-fen-fa-pai-chu-fa-python-dai-ma-java-dai-ma-by-/
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * @Author: zhunn
 * @Date: 2020-10-22 14:26
 * @Description: 搜索二维矩阵 II
 */
public class Solution {


    /**
     * 从左下角开始
     * <p>
     * 如果当前数比目标元素小，当前列就不可能存在目标值，“指针”就向右移一格（纵坐标加 11）；
     * 如果当前数比目标元素大，当前行就不可能存在目标值，“指针”就向上移一格（横坐标减 11）。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null) {
            return false;
        }

        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int col = matrix[0].length;

        if (col == 0) {
            return false;
        }

        int x = rows - 1;
        int y = 0;
        int value;

        while (x >= 0 && y < col) {
            value = matrix[x][y];
            if (value > target) {
                x--;
            } else if (value < target) {
                y++;
            } else {
                return true;
            }
        }

        return false;
    }


}
