package com.chen.algorithm.rectangle;

import org.junit.Test;

import java.util.ArrayList;

/**
 * User: chenweijie
 * Date: 10/16/17
 * Time: 11:30 PM
 * Description:输入一个矩阵，按照从外向里以顺时针的顺序
 * 一次打印出每一个数字 （http://www.cnblogs.com/sunniest/p/4596182.html）
 */
public class TestClockwiseOutput {


    @Test
    public void test() {
        int[][] num = new int[4][4];
        int n = 4;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = count++;
            }
        }
        printMatrix(num);
    }


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, top = 0, bottom = row - 1, right = col - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            if (top != bottom) {
                for (int t = right - 1; t >= left; t--) {
                    list.add(matrix[bottom][t]);
                }
            }
            if (left != right) {
                for (int k = bottom - 1; k > top; k--) {
                    list.add(matrix[k][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return list;
    }


}
