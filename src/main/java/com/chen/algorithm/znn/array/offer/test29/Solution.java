package com.chen.algorithm.znn.array.offer.test29;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @Auther: zhunn
 * @Date: 2020/10/10 13:58
 * @Description: 顺时针从外往里打印矩阵（螺旋矩阵，力扣第54题）
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[u][i];
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[d][i];
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int numEle = matrix.length * matrix[0].length;
        int[] result = new int[numEle];
        int idx = 0;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result[idx++] = matrix[top][i];
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result[idx++] = matrix[i][right];
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result[idx++] = matrix[bottom][i];
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result[idx++] = matrix[i][left];
                numEle--;
            }
            left++;
        }
        return result;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = spiralOrder1(matrix);
        System.out.println(Arrays.toString(res));
    }

}
