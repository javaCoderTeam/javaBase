package com.chen.algorithm.study.test3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 写的不简洁
 *
 * @author :  chen weijie
 * @Date: 2019-09-03 00:00
 */
public class Solution4 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }


    @Test
    public void testCase() {
        System.out.println(lengthOfLongestSubstring("cdfcg"));
    }


}
