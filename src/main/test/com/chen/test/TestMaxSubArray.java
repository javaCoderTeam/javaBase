package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 10:49
 */
public class TestMaxSubArray {


    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp = temp + nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }


    @Test
    public void print() {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }


}
