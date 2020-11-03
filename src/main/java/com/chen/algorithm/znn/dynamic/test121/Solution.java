package com.chen.algorithm.znn.dynamic.test121;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/kan-yi-bian-jiu-wang-bu-diao-de-jie-ti-si-lu-bu-di/
 * @Auther: zhunn
 * @Date: 2020/11/3 19:59
 * @Description: 买卖股票的最佳时机：双指针法
 * 121、122（贪心）、123、188、309、714
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
