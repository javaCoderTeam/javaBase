package com.chen.algorithm.study.test3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 写的不简洁
 * @author :  chen weijie
 * @Date: 2019-09-03 00:00
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        if (" ".equals(s)) {
            return 1;
        }

        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (int j = start; j < chars.length; j++) {
                if (!set.add(chars[j])) {
                    max = Math.max(max, set.size());
                    set.clear();
                    start++;
                    break;
                } else {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }


    @Test
    public void testCase() {
        System.out.println(lengthOfLongestSubstring("cdfcg"));
    }


}
