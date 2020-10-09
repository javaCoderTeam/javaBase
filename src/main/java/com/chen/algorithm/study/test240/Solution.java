package com.chen.algorithm.study.test240;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/er-fen-fa-pai-chu-fa-python-dai-ma-java-dai-ma-by-/
 *
 * @author :  chen weijie
 * @Date: 2019-12-22 14:26
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
