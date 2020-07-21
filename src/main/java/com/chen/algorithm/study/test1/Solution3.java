package com.chen.algorithm.study.test1;

import org.junit.Test;

/**
 * 正确
 *
 * @author :  chen weijie
 * @Date: 2019-09-02 23:52
 */
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }

        }
        throw new RuntimeException();
    }


    @Test
    public void testCase() {

        int[] array = {4, 5, 6, 7, 2};

        int[] result = twoSum(array, 9);

        for (int value : result) {
            System.out.println(value);

        }

    }


}
