package com.chen.algorithm.study.test152;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-09-04 18:35
 */
public class Solution3 {


//    5 3 -2 10

    public int maxProduct(int[] nums) {
        return digui(nums.length - 1, 1, nums, nums[0], nums[0], nums[0]);
    }


    public int digui(int maxLevel, int currLevel, int[] nums, int currMax, int currMin, int max) {

        if (maxLevel < currLevel) {
            return max;
        }
        if (nums[currLevel] > 0) {
            currMax = Math.max(currMax * nums[currLevel], nums[currLevel]);
            currMin = Math.min(currMin * nums[currLevel], nums[currLevel]);
        } else {
            currMax = Math.max(currMin * nums[currLevel], nums[currLevel]);
            currMin = Math.min(currMax * nums[currLevel], nums[currLevel]);
        }
        max = Math.max(max, currMax);

        return digui(maxLevel, currLevel + 1, nums, currMax, currMin, max);
    }

    @Test
    public void testCase() {

        int[] nums = {5, 3, -2, 10};
        System.out.println(maxProduct(nums));
    }


}
