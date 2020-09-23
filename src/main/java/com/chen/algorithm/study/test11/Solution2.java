package com.chen.algorithm.study.test11;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-08 23:37
 */
public class Solution2 {


    public int maxArea(int[] height) {

        int maxArea = 0;

        int i = 0, j = height.length - 1;

        while (i < j){
            maxArea = Math.max((j - i) * Math.min(height[i], height[j]), maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
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
