package com.chen.algorithm.znn.tree.test96;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
 * 思路
 * 给定一个有序序列 1⋯n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，将该数字作为树根，
 * 将 1⋯(i−1) 序列作为左子树，将 (i+1)⋯n 序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。
 * <p>
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @Auther: zhunn
 * @Date: 2020/10/29 17:49
 * @Description: 不同的二叉搜索树：1-动态规划
 */
public class Solution {

    /**
     * 1-动态规划 求G(n)
     * G(0) = 1，G(1) = 1
     * G(n) = G(i-1)*G(n-i) 求和（1<= i <=n）
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
