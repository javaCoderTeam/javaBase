package com.chen.algorithm.study.test27;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-08 01:17
 */
public class Solution {


    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }


    @Test
    public void testCase() {
        System.out.println(removeElement(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 4, 4}, 2));

    }

}
