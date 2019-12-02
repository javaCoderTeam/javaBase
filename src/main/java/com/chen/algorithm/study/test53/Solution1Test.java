package com.chen.algorithm.study.test53;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-10-21 23:44
 */
public class Solution1Test {


    public int maxSubArray(int[] nums) {

        int max = 0, sum = 0;

        for (int num : nums) {
            sum = Math.max(0, sum);
            sum = sum + num;
            max = Math.max(sum, max);
        }
        return max;
    }


    @Test
    public void testCase() {


        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));


    }


}
