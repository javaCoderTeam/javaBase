package com.chen.algorithm.study.test152;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 * @author :  chen weijie
 * @Date: 2019-12-11 23:08
 */
public class Solution {


    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(num, num * imax);
            imin = Math.min(num, num * imin);
            max = Math.max(imax, max);
        }
        return max;
    }

    @Test
    public void testCase() {


        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));
    }


}
