package com.chen.algorithm.study.test300;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *
 * @author :  chen weijie
 * @Date: 2019-12-22 16:28
 */
public class Solution2 {

    public int lengthOfList(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            int tem = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tem = Math.max(tem, dp[j]);
                }
            }
            dp[i] = tem + 1;
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
