package com.chen.algorithm.study.test227;

import org.junit.Test;

import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-08-05 15:50
 */
public class Solution2 {


    public void vert() {
        String s = "458";
        int n = 0;
        for (char c : s.toCharArray()) {
            n = n * 10 + (c - '0');
        }
        System.out.println(n);
    }


    public int calculate(String s) {
        int res = 0;
        char sign = '+';

        if (s == null || s.length() == 0){
            return 0;
        }
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ( Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int pre = stack.pop();
                    stack.push(pre * num);
                } else if (sign == '/') {
                    int pre = stack.pop();
                    stack.push(pre / num);
                }
                sign = c;
                num = 0;
            }
        }

        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }


    @Test
    public void testCase() {
        System.out.println(calculate("-30+5/2 "));
    }


}
