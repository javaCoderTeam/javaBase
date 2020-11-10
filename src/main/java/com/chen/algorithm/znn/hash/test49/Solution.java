package com.chen.algorithm.znn.hash.test49;

import org.junit.Test;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * @Auther: zhunn
 * @Date: 2020/10/26 11:19
 * @Description: 字母异位词分组
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> resuMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!resuMap.containsKey(key)) {
                resuMap.put(key, new ArrayList<>());
            }
            resuMap.get(key).add(strs[i]);
        }
        return new ArrayList<>(resuMap.values());
    }

    @Test
    public void test() {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(words);
        System.out.println(result);
    }
}
