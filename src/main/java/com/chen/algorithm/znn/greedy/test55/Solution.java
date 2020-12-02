package com.chen.algorithm.znn.greedy.test55;

import org.junit.Test;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @Auther: zhunn
 * @Date: 2020/11/2 14:51
 * @Description: 跳跃游戏：1-贪心算法；2-动态规划
 */
public class Solution {

    /**
     * 1-贪心算法
     * 倒序遍历，如果n-2下标能到达n-1下标，意味着前面只要有坐标能够到达n-2即可完成跳跃，于是末尾位置更改为n-2，这样构成一个子问题，迭代求解。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

    /**
     * 2-动态规划
     *
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
