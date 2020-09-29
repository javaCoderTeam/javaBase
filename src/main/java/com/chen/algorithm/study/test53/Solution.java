package com.chen.algorithm.study.test53;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-10-21 22:50
 */
public class Solution {

    public int maxSubArray(int[] nums) {

        int max = nums[0];   // 保存最大的结果
        int sum = 0;            // 保存当前的子序和

        for (int num : nums) {
            if (sum > 0) {     // sum是正数，意味着后面有机会再创新高，可以继续加
                sum += num;
            } else {           // sum是负的，还不如直接从当前位重新开始算，也比(负数+当前值)要大吧
                sum = num;
            }
            max = Math.max(max, sum);   // 每一步都更新最大值
        }
        return max;
    }


    public int maxSubArray2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }


    @Test
    public void testCase() {

        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }


}
