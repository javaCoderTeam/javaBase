package com.chen.algorithm.study.test70;

import org.junit.Test;

/**
 * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
 * <p>
 * 第 i 阶可以由以下两种方法得到：
 * <p>
 * 在第(i−1) 阶后向上爬一阶。
 * <p>
 * 在第(i−2) 阶后向上爬 2 阶。
 * <p>
 * 所以到达第 i 阶的方法总数就是到第(i−1) 阶和第 (i−2) 阶的方法数之和。
 * <p>
 * 令 dp[i] 表示能到达第 i 阶的方法总数：
 * <p>
 * dp[i]=dp[i-1]+dp[i-2]
 * <p>
 * <p>
 * 在上述方法中，我们使用 dp 数组，其中 dp[i]=dp[i-1]+dp[i-2]。可以很容易通过分析得出 dp[i] 其实就是第 i 个斐波那契数。
 * <p>
 * Fib(n)=Fib(n-1)+Fib(n-2)
 * <p>
 * 现在我们必须找出以 1 和 2 作为第一项和第二项的斐波那契数列中的第 n 个数，也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2
 *
 * @author :  chen weijie
 * @Date: 2019-10-22 00:07
 */
public class Solution1 {


    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    @Test
    public void testCase() {
        System.out.println(climbStairs(10));
    }


}
