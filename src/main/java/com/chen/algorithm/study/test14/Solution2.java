package com.chen.algorithm.study.test14;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-09-05 00:55
 */
public class Solution2 {


    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }


    @Test
    public void testCase() {


        String[] strings = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strings));


    }


}
