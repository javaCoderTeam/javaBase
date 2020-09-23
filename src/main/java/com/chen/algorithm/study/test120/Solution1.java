package com.chen.algorithm.study.test120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-05-17 20:07
 */
public class Solution1 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    @Test
    public void testCase() {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));

    }

}
