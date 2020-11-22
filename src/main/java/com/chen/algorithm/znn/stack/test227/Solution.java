package com.chen.algorithm.znn.stack.test227;

import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * @Auther: zhunn
 * @Date: 2020/10/27 11:11
 * @Description: 基本计算II
 */
public class Solution {

    public void vert() {
        String a = "796";
        int num = 0;
        for (char c : a.toCharArray()) {
            num = num * 10 + (c - '0');
        }
        System.out.println(num);
    }

    public int calculate(String s) {
        if (s == null || s.trim().equals("")) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        char sign = '+';        // 记录 num 前的符号，初始化为 +
        int num = 0;            // 记录算式中的数字
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {   //不只是遇到新的符号会触发入栈，当i走到了算式的尽头（i == s.size() - 1），也应该将前面的数字入栈，方便后续计算最终结果。
                int pre;
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    pre = stack.pop();
                    stack.push(pre * num);
                } else if (sign == '/') {
                    pre = stack.pop();
                    stack.push(pre / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    @Test
    public void test() {
        vert();
        System.out.println(calculate("60+20-30+5/2 "));
    }


}
