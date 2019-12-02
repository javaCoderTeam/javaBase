package com.chen.algorithm.study.test31;

/**
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/ *
 * 排列，离散数学
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 15:43
 */
public class Solution {


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        revert(nums, i + 1);
    }


    private void revert(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
