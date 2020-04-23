package com.chen.algorithm.study.test300;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *
 * @author :  chen weijie
 * @Date: 2019-12-22 16:28
 */
public class Solution {

    public int lengthOfList(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    @Test
    public void testCase() {
        int[] n = {4, 1, -4, 7, -2, 9, 0};

        System.out.println(lengthOfList(n));


    }


}
