package com.chen.algorithm.study.test26;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-08 00:28
 */
public class Solution {


    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int temp = 0;
        int count = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            while (nums[i] == nums[i + 1] && count > 1) {
                temp = nums[i + 1];
                for (int j = i + 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = temp;
                count--;

            }
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }

        return count;
    }


    @Test
    public void testCase() {
        System.out.println(removeDuplicates(new int[]{1, 1}));
    }


}
