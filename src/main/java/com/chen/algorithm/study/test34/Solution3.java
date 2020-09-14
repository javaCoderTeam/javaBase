package com.chen.algorithm.study.test34;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-09-14 01:34
 */
public class Solution3 {


    public int[] searchRange(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int[] res = new int[2];

        res[0] = leftIndex(target, nums);
        res[1] = rightIndex(target, nums);

        return res;
    }


    private int leftIndex(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left <= nums.length - 1 && nums[left] == target) {
            return left;
        }

        return -1;
    }

    private int rightIndex(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }

        return -1;
    }

    @Test
    public void testCase() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        System.out.println(Arrays.toString(res));

    }
}
