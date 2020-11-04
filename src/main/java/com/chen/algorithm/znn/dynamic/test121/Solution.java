package com.chen.algorithm.znn.dynamic.test121;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/kan-yi-bian-jiu-wang-bu-diao-de-jie-ti-si-lu-bu-di/
 * @Auther: zhunn
 * @Date: 2020/11/3 19:59
 * @Description: 买卖股票的最佳时机：双指针法
 * 121（最多买卖一次）、122（贪心，最多买卖多次，不限次）、123（最多买卖两次）、188（最多买卖K次）、309（可以买卖多次，有冷冻期）、714（可以买卖多次，一次买卖含一次手续费）
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class Solution {

    public int maxProfit(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(max, nums[i] - min);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }
}
