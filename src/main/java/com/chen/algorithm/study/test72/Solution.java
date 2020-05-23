package com.chen.algorithm.study.test72;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
 *
 * @author :  chen weijie
 * @Date: 2020-05-17 13:32
 */
public class Solution {


    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int[][] D = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    D[i][j] = D[i - 1][j - 1];
                } else {
                    D[i][j] = Math.min(Math.min(D[i - 1][j - 1], D[i][j - 1]), D[i - 1][j]) + 1;
                }
            }
        }
        return D[n][m];
    }


    @Test
    public void testCase() {

        System.out.println(minDistance("horse", "ros"));
    }


}
