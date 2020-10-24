package com.chen.algorithm.znn.array.test283;

import org.junit.Test;

import java.util.Arrays;

/**
 * 移动0
 * @author: zhunn
 * @Date: 2019-11-03 18:44
 * @Description: 移动0至末尾
 */
public class Solution2 {

    /**
     * @param nums
     * @return
     */
    public int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
        return nums;
    }

    @Test
    public void testCase() {

        int[] n = {0, 1, 0, 3, 12};
        moveZeroes(n);
        System.out.println(Arrays.toString(n));


    }

}
