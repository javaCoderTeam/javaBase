package com.chen.algorithm.study.test14;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-11 00:34
 */
public class Solution3 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prex = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prex)) {
                prex = prex.substring(0, prex.length() - 1);
                if (prex.isEmpty()) {
                    return "";
                }
            }
        }
        return prex;
    }

    @Test
    public void testCase() {
        String[] strings = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strings));


    }


    public static void main(String[] args) {
        String[] stringArr = {"flower", "flow", "flight"};
        String pre = stringArr[0];
        for (int i = 0; i<stringArr.length;i++) {
            String  s = stringArr[i];
            while (!s.startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
                if ("".equals(pre)) {
                    System.out.println();
                }
            }
        }
        System.out.println(pre);
    }

}
