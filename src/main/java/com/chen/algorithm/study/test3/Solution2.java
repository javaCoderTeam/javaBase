package com.chen.algorithm.study.test3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2019-09-03 00:33
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (characterIntegerMap.containsKey(s.charAt(j))) {
                i = Math.max(i, characterIntegerMap.get(s.charAt(j)));
            }
            max = Math.max(max, j - i + 1);
            characterIntegerMap.put(s.charAt(j), j + 1);
        }
        return max;
    }

    @Test
    public void testCase() {
        System.out.println(lengthOfLongestSubstring("cdfkfg"));
    }
}
