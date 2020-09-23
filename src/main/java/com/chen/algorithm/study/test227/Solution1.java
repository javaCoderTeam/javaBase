package com.chen.algorithm.study.test227;

import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-09-21 23:32
 */
public class Solution1 {


    public int calculate(String s) {
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (c == '+') {
                    stack.push(num);
                } else if (c == '-') {
                    stack.push(-num);
                } else if (c == '/') {
                    Integer pre = stack.pop();
                    stack.push(pre / num);
                } else if (c == '*') {
                    Integer pre = stack.pop();
                    stack.push(pre * num);
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
}
