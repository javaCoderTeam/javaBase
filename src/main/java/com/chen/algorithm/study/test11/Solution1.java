package com.chen.algorithm.study.test11;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-08 23:37
 */
public class Solution1 {


    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (r > l) {
            maxArea = Math.max((r - l) * Math.min(height[l], height[r]), maxArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }


    @Test
    public void testCase() {

        int[] n = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(n));

    }


}
