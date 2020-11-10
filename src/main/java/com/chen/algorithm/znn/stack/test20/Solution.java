package com.chen.algorithm.znn.stack.test20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
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
