package com.chen.algorithm.znn.string.test5;

import org.junit.Test;

/**
 * 官方解法：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
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
     * 状态转移方程：dp[i][j]表示字符串 s 的第 i 到 j 个字母组成的串是否是回文串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for (int x = 0; x < n; x++) {
            for (int i = 0; i + x < n; i++) {   //x 表示增量，子串长度，
                int j = i + x;
                if (x == 0) {       //增量是0
                    dp[i][j] = true;
                } else if (x == 1) {    //增量是1，只有两个字符
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));    // 判断c aba c是否是回文串，需判断aba是否是回文串以及左右两边的字符是否相等
                }

                if (dp[i][j] && j - i + 1 > ans.length()) {     // i到j组成的串是回文串，并且回文串的长度是否大于之前的回文串长度
                    ans = s.substring(i, j + 1);
                }

                //if (dp[i][j] && x + 1 > ans.length()) {     // 可以将j-i+1替换成x+1，i+x+1替换成j+1，都表示回文串的长度
                //    ans = s.substring(i, i + x + 1);
                //}
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
        System.out.println(longestPalindrome("dcacdefd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

}
