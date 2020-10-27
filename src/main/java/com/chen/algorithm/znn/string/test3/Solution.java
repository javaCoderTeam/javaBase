package com.chen.algorithm.znn.string.test3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhunn
 * @Date: 2020/10/27 16:02
 * @Description: 无重复字符的最长子串
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int n = s.length();

        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }

            ans = Math.max(ans, end - start + 1);
            map.put(c, end + 1);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
