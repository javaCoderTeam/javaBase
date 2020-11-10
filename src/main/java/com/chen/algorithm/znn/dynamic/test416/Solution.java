package com.chen.algorithm.znn.dynamic.test416;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @Auther: zhunn
 * @Date: 2020/11/5 18:27
 * @Description: 分割等和子集：1-动态规划, 0-1背包问题；2-动态规划-剪枝；3-动态规划-优化空间
 */
public class Solution {

    /**
     * 1-动态规划, 0-1背包问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {  // 特判：如果是奇数，就不符合要求
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];  // 创建二维数组，行：物品索引，列：容量（包括0）
        //dp[0][0] = true;                // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的

        if (nums[0] <= target) {        // 先填表格第0行，第 1 个数只能让容积为它自己的背包恰好装满
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {     //再填表格后面几行
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];    //直接把结果从上面一行抄下来，然后再修正
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[len - 1][target];
    }

    /**
     * 2-动态规划-剪枝
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        dp[0][0] = true;        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

                if (dp[i][target]) {  // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
                    return true;
                }
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 3-动态规划-优化空间
     *
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {   // 使用一维表格,从后向前
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
