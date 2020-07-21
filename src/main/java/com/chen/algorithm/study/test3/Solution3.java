package com.chen.algorithm.study.test3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2019-09-07 18:58
 */
public class Solution3 {


    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>(s.length());
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);

        }
        return max;
    }


    @Test
    public void testCase() {
        System.out.println(lengthOfLongestSubstring("ccfkfg"));
    }
}
