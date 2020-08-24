package com.chen.algorithm.study.test215;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-12-12 23:50
 */
public class Solution {


    public int findKthLargest(int[] nums, int k) {


        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < nums.length ; j++) {

                if (nums[j] > nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[k - 1];
    }


    @Test
    public void testCase() {
        int[] n = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(n, 4));

    }


}
