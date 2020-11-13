package com.chen.algorithm.znn.string.test415;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * @Auther: zhunn
 * @Date: 2020/10/27 16:03
 * @Description: 字符串相加
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + carry;
            ans.append(temp % 10);
            carry = temp / 10;
            i--;
            j--;
        }

        return ans.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addStrings("623", "401"));
    }
}
