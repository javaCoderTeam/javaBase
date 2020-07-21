package com.chen.algorithm.study.test48;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-12 00:04
 */
public class Solution {


    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        //先转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
                System.out.println("=====" + JSONObject.toJSONString(matrix));
            }
        }

        // 反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }
        }
    }


    @Test
    public void testCase() {

        int[][] matrix = new int[3][3];

        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

        rotate(matrix);

        System.out.println("last:" + JSONObject.toJSONString(matrix));

    }


}
