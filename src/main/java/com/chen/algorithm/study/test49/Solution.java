package com.chen.algorithm.study.test49;

import java.util.*;

/**
 * @author :  chen weijie
 * @Date: 2019-11-12 00:34
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> isValid(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (!res.containsKey(s)) {
                res.put(s, new ArrayList<>());
            }
            res.get(s).add(str);


        }

        return new ArrayList<>(res.values());
    }


}
