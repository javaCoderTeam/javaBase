package com.chen.algorithm.study.test300;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *
 * @author :  chen weijie
 * @Date: 2019-12-22 16:28
 */
public class Solution3 {

    public int lengthOfList(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        int[] dp = new int[len];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }


    @Test
    public void testCase() {
        int[] n = {4, 1, -4, 7, -2, 9, 0};

        System.out.println(lengthOfList(n));


    }


}
