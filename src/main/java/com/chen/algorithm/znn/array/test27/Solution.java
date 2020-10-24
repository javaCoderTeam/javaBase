package com.chen.algorithm.znn.array.test27;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/10/10 16:40
 * @Description: 移除元素，双指针法
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    @Test
    public void test() {
        System.out.println(removeElement(new int[]{1, 1, 2, 2, 3, 5, 6, 7, 8}, 2));
    }
}
