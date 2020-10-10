package com.chen.algorithm.study.offer.test29;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/10/10 13:58
 * @Description: 顺时针从外往里打印矩阵（螺旋矩阵，力扣第54题）
 */
public class Solution {

    public static int[] spiralOrder(int[][] matrix) {
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

    private static int[] spiralOrder1(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = spiralOrder1(matrix);
        System.out.println(Arrays.toString(res));
    }

}
