package com.chen.algorithm.study.test34;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 17:56
 */
public class Solution1 {


    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
        }
        int pos = (left < nums.length) ? left : nums.length - 1;
        if (nums[pos] != target) return -1;
        return left;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
        }
        int pos = (left - 1 >= 0) ? left - 1 : 0;
        if (nums[pos] != target) return -1;
        return left - 1;
    }

    @Test
    public void testCase() {


        int[] n = {5, 7, 7, 8, 8, 10};

        int[] result = searchRange(n, 6);

        System.out.println(JSONObject.toJSONString(result));

    }


}
