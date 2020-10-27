package com.chen.algorithm.znn.string.test14;

import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/27 15:51
 * @Description: 最长公共前缀
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                if (prefix.length() == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
