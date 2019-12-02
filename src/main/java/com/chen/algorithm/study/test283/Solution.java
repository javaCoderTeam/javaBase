package com.chen.algorithm.study.test283;

import org.junit.Test;

/**
 * wrong.......wrong.......wrong.......
 *
 * @author :  chen weijie
 * @Date: 2019-11-03 18:44
 */
public class Solution {

    public void moveZeroes(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == j) {
                return;
            }
            if (nums[i] == 0) {
                while (nums[j] == 0) {
                    j--;
                }
                int tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
            }
        }
    }

    @Test
    public void testCase() {

        int[] n = {0, 1, 0, 3, 12};
        moveZeroes(n);
        System.out.println(n);


    }


}
