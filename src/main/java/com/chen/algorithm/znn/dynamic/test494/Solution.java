package com.chen.algorithm.znn.dynamic.test494;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/target-sum/solution/huan-yi-xia-jiao-du-ke-yi-zhuan-huan-wei-dian-xing/
 *
 * @Auther: zhunn
 * @Date: 2020/11/6 16:03
 * @Description: 目标和：1-枚举；2-动态规划，0-1背包问题；3-动态规划-优化空间
 */
public class Solution {


    int count = 0;

    /**
     * 1-暴力枚举
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return count;
        }
        caculate(nums, 0, 0, S);
        return count;
    }

    private void caculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) count++;
            return;
        }
        caculate(nums, i + 1, sum + nums[i], S);
        caculate(nums, i + 1, sum - nums[i], S);
    }

    /**
     * 2-动态规划，0-1背包问题
     * 时间复杂度：O(n*sum),其中 N 是数组 nums 的长度。
     * 空间复杂度：O(n*sum)
     * dp[i][j]： i(1 ~ len)表示遍历（不一定选）了 i 个元素，j(0 ~ sum) 表示它们的和
     * <p>
     * 初始化：0个元素，和为0，情况有1种（因为没有元素，所以只能不选，和为0）：dp[0][0] = 1
     * 不选当前元素，即"部分和"(即j)与之前相同：dp[i][j] = dp[i - 1][j]
     * 可选可不选，不选的情况是2，选当前元素的话则之前的状态应为dp[i - 1][j - num]（这里的num指的是当前元素的值，即代码中的nums[i - 1]），二者相加，即：dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num]
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum + S) & 1) == 1) { // 背包容量为整数，sum + S为奇数的话不满足要求
            return 0;
        }
        if (S > sum) {  // 目标和不可能大于总和
            return 0;
        }

        int target = (sum + S) >> 1;
        int len = nums.length;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;

        // 如果迭代部分 j 的初值赋 1 的话，就要先初始化 j = 0 的情况
        /* int count = 1;
        for (int i = 1; i <= len; i++) {
            // ±0 均可
            if (nums[i - 1] == 0) {
                count *= 2;
            }
            dp[i][0] = count;
        } */

        // 01背包
        // i(1 ~ len)表示遍历（不一定选）了 i 个元素，j(0 ~ sum) 表示它们的和
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] < 0) {  // 装不下（不选当前元素）
                    dp[i][j] = dp[i - 1][j];
                } else {                    // 可装可不装（当前元素可选可不选）
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[len][target];
    }

    public int findTargetSumWays2_test(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum + S) & 1) == 1) { // 奇数
            return 0;
        }
        if (S > sum) {
            return 0;
        }

        int target = (S + sum) >> 1;
        int len = nums.length;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][target];
    }

    public int findTargetSumWays3(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum + S) & 1) == 1) { // 背包容量为整数，sum+S为奇数的话不满足要求
            return 0;
        }
        if (S > sum) {      // 目标和不可能大于总和
            return 0;
        }

        int target = (sum + S) >> 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays3(nums, 3));
    }
}
