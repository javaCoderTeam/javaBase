package com.chen.algorithm.study.test14;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 错误
 *
 *
 * @author :  chen weijie
 * @Date: 2019-09-05 00:17
 */
public class Solution {


    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {

            return "";
        }


        String result;
        Map<String, String> map = new HashMap<>();

        loop:
        for (int j = 0; ; j++) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] == null || "".equals(strs[i])) {
                    return "";
                }

                if (i == 0) {
                    map.put(strs[i].substring(0, j), strs[i].substring(0, j));
                    continue;
                }
                if (!map.containsKey(strs[i].substring(0, j))) {
                    result = strs[i].substring(0, j - 1);
                    break loop;
                }
            }
        }
        return result;

    }

    @Test
    public void testCase(){


        String [] strings = {""};

        System.out.println(longestCommonPrefix(strings));



    }


}
