package com.chen.algorithm.study.test242;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-03 22:12
 */
public class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int [] counter = new int[26];
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
    public void testCase(){

        System.out.println(isAnagram("anagram","nagaram"));

    }


}
