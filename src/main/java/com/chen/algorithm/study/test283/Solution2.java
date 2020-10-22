package com.chen.algorithm.study.test283;

import org.junit.Test;

import java.util.Arrays;

/**
 * 移动0
 * @author :  chen weijie
 * @Date: 2019-11-03 18:44
 * @Description: zhunn 移动0至末尾
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        int i = 0;

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                nums[i++] = nums[k];
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }


    }

    @Test
    public void testCase() {

        int[] n = {0, 1, 0, 3, 12};
        moveZeroes(n);
        System.out.println(Arrays.toString(n));


    }


    /**
     * @author: zhunn
     * @param nums
     * @return
     */
    public int[] moveZeroes1(int[] nums) {
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
}
