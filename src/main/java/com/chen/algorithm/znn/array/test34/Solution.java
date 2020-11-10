package com.chen.algorithm.znn.array.test34;

import org.junit.Test;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @Auther: zhunn
 * @Date: 2020/10/10 17:04
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * (可使用二分查找到第一个与target相等元素和最后一个与target相等元素 方式，返回下标)
 */
public class Solution {

    /**
     * 当key=array[mid]时， 往左边一个一个逼近，right = mid -1; 返回left
     *
     * @param nums
     * @param target
     * @return
     */
    private int leftIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left <= nums.length - 1 && nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 当key=array[mid]时， 往右边一个一个逼近，left = mid + 1; 返回right
     *
     * @param nums
     * @param target
     * @return
     */
    private int rightIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
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

    public int[] find(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = leftIndex(nums, target);
        res[1] = rightIndex(nums, target);
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 8, 10};
        int[] res = find(nums, 8);
        System.out.println(Arrays.toString(res));
    }

}
