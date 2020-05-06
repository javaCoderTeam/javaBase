package com.chen.algorithm.study.test20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-05-07 01:48
 */
public class Solution3 {


    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>(3);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        if (s == null || s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {

                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
