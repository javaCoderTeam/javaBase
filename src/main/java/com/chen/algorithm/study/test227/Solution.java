package com.chen.algorithm.study.test227;

import org.junit.Test;

import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-08-05 15:50
 */
public class Solution {


    public void vert() {
        String s = "458";
        int n = 0;
        for (char c : s.toCharArray()) {
            n = n * 10 + (c - '0');
        }
        System.out.println(n);
    }


    public int calculate(String s) {

        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 如果不是数字，就是遇到了下一个符号，或者等于最后一个字符
            // 之前的数字和符号就要存进栈中
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
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }

        return res;
    }


    @Test
    public void testCase() {
        System.out.println(calculate("3/2"));
    }


}
