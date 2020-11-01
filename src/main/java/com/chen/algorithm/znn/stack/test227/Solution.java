package com.chen.algorithm.znn.stack.test227;

import org.junit.Test;

import java.util.Stack;

/**
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
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
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