package com.chen.algorithm.study.test96;

/**
 *
 * 暂时跳过。。。
 * @author :  chen weijie
 * @Date: 2019-12-03 00:44
 */
public class Solution {


    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }


}
