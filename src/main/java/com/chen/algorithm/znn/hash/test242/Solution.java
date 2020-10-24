package com.chen.algorithm.znn.hash.test242;

import org.junit.Test;

/**
 * @Author: zhunn
 * @Date: 2020-10-22 22:12
 * @Description: 有效的字母异位词。哈希表
 */
public class Solution {

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int n : counter) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testCase() {

        System.out.println(isAnagram("anagram", "nagaram"));

    }

}
