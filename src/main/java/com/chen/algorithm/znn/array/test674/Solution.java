package com.chen.algorithm.znn.array.test674;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/zui-chang-lian-xu-di-zeng-xu-lie-by-leetcode/
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
