package com.chen.algorithm.znn.greedy.test55;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/11/2 14:51
 * @Description: 跳跃游戏：1-贪心算法；2-动态规划
 */
public class Solution {

    /**
     * 1-贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

    /**
     * 2-动态规划
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果之前的j节点可达，并且从此节点可以到跳到i
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean res = canJump(nums2);
        System.out.println(res);
    }
}
