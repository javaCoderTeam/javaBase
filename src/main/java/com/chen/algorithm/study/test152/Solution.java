package com.chen.algorithm.study.test152;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 *
 * @author :  chen weijie
 * @Date: 2019-12-11 23:08
 */
public class Solution {


    public int maxProduct(int[] nums) {

        int max = nums[0];
        int iMax = nums[0];
        int iMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(num, iMax * num);
            iMin = Math.min(num, iMin * num);
            max = Math.max(max, iMax);
        }

        return max;
    }

    @Test
    public void testCase() {


        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));
    }


}
