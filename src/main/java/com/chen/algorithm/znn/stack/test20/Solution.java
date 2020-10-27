package com.chen.algorithm.znn.stack.test20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: zhunn
 * @Date: 2020/10/27 14:18
 * @Description: 有效的括号
 */
public class Solution {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Map<Character, Character> signMap = new HashMap<>(3);
        signMap.put('(', ')');
        signMap.put('[', ']');
        signMap.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (signMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || signMap.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(isValid(""));
        System.out.println(isValid(" "));
        System.out.println(isValid("( "));
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
