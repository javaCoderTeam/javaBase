package com.chen.algorithm.znn.dynamic.test213;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhunn
 * @Date: 2020/11/6 17:45
 * @Description: 打家劫舍 II：在198题的基础上，选择不偷第一家或不偷最后一家
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, len - 1)),
                myRob(Arrays.copyOfRange(nums, 1, len)));

    }

    private int myRob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    private int myRob(int[] nums) {
        int first = nums[0], second = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], temp);
            first = temp;
        }
        return second;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
