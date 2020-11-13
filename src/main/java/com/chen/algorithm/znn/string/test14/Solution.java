package com.chen.algorithm.znn.string.test14;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
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
            while (!strs[i].startsWith(prefix)) {       // 如果不包含此前缀，缩小前缀继续比对
                if (prefix.length() == 0) {             // 如果前缀长度已缩小为0，仍没有符合的，直接返回空串
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);  // 缩小前缀
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
