package com.chen.algorithm.study.test287;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2019-12-22 16:22
 */
public class Solution {


    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }


}
