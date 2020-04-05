package com.chen.algorithm.study.test300;

/**
 * @author :  chen weijie
 * @Date: 2019-12-22 16:28
 */
public class Solution {

    public int lengthOfLIST(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }


        int max = 1;
        int length = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp) {
                length++;
                max = Math.max(length, max);
                temp = nums[i];
            } else {
                temp = nums[i - 1];
                length = 1;
            }
        }


        return max;
    }

}
