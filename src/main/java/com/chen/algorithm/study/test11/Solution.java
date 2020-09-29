package com.chen.algorithm.study.test11;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-08 23:19
 */
public class Solution {

    public int maxArea(int[] height) {

        int max = 0;

        int i = 0, j = height.length - 1;

        while (i < j) {

            int d = Math.min(height[i], height[j]);
            max = Math.max((j - i) * d, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
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
