package com.chen.algorithm.znn.string.test5;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/27 16:02
 * @Description: 最长回文子串：
 * 1-动态规划；时间复杂度：O(n2)，空间复杂度：O(n2)
 * 2-中心扩展算法；时间复杂度：O(n2)，空间复杂度：O(1)
 */
public class Solution {

    /**
     * 1-动态规划
     *
     * @param s
     * @return x 表示增量，子串长度，
     * 状态转移方程：dp[i][j]表示从i到j的字符串 表示字符串 s 的第 i 到 j 个字母组成的串
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for (int x = 0; x < n; x++) {
            for (int i = 0; i + x < n; i++) {
                int j = i + x;
                if (x == 0) {
                    dp[i][j] = true;
                } else if (x == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
                }

                if (dp[i][j] && x + 1 > ans.length()) {
                    ans = s.substring(i, i + x + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 2-中心扩展算法
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    @Test
    public void test() {
        System.out.println("123456".substring(0, 3));
        System.out.println(longestPalindrome1("dcacdefd"));
        System.out.println(longestPalindrome1("babad"));
        System.out.println(longestPalindrome1("cbbd"));
    }

}
