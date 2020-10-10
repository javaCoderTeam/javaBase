package com.chen.algorithm.study.test1;

import org.junit.Test;

/**
 * 正确
 * @author :  chen weijie
 * @Date: 2019-09-02 23:52
 * @Description: 两数之和
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("没有适合的结果");
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
