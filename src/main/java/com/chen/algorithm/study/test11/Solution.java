package com.chen.algorithm.study.test11;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-08 23:19
 */
public class Solution {

    public int maxArea(int[] height) {

        int width = 0;
        int high = 0;
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                width = j - i;
                high = Math.min(height[i], height[j]);
                int area = width * high;
                max = Math.max(area, max);
            }
        }
        return max;
    }


    @Test
    public void testCase() {

        int[] n = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(n));

    }


}
