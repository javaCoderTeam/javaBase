package com.chen.algorithm.znn.array.test674;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/zui-chang-lian-xu-di-zeng-xu-lie-by-leetcode/
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 最长连续递增序列：滑动窗口
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int res = 0, anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                anchor = i;
            }
            res = Math.max(res, i - anchor + 1);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 4, 7};
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS(nums2));
    }
}
