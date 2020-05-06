package com.chen.test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :  chen weijie
 * @Date: 2020-05-02 09:48
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        if (" ".equals(s)) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (set.contains(chars[j])) {
                    set.clear();
                    break;
                }
                set.add(chars[j]);
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }


    @Test
    public void testCase() {
        System.out.println(lengthOfLongestSubstring("a"));
    }


}
