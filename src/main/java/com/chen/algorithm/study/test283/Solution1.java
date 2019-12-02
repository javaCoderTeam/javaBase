package com.chen.algorithm.study.test283;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/move-zeroes/solution/javashuang-zhi-zhen-zuo-fa-by-arthur-24/
 *
 * @author :  chen weijie
 * @Date: 2019-11-03 18:44
 */
public class Solution1 {

    public void moveZeroes(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i != j) {
                    nums[i] = nums[j];
                }
                i++;
            }
        }

        for (; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    @Test
    public void testCase() {

        int[] n = {0, 1, 0, 3, 12};
        moveZeroes(n);
        System.out.println(n);


    }


}
