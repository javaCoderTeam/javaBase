package com.chen.algorithm.rectangle;

/**
 * @author :  chen weijie
 * @Date: 2020-06-26 00:57
 */
public class Test {

    @org.junit.Test
    public void test() {
        int[][] num = new int[4][4];
        int n = 4;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = count++;
            }
        }
        spiralOrder(num);
    }

    public int[] spiralOrder(int[][] matrix) {

        int left = 0, right = matrix[0].length, ceil = 0, floor = matrix.length;
        int[] n = new int[right * floor];
        int x = 0;

        print(matrix, n, left, right, ceil, floor, x);
        return n;
    }

    public void print(int[][] matrix, int[] n, int left, int right, int ceil, int floor, int x) {
        if (left > right || ceil > floor) {
            return;
        }

        for (int i = left; i < right; i++) {
            n[x++] = matrix[ceil][i];
        }

        for (int j = ceil + 1; j < floor; j++) {
            n[x++] = matrix[j][right - 1];
        }

        if (left != right) {
            for (int k = right - 2; k >= left; k--) {
                n[x++] = matrix[floor - 1][k];
            }
        }
        if (ceil != floor) {
            for (int z = floor - 2; z > ceil; z--) {
                n[x++] = matrix[z][left];
            }
        }

        left++;
        right--;
        ceil++;
        floor--;
        print(matrix, n, left, right, ceil, floor, x);
    }
}
