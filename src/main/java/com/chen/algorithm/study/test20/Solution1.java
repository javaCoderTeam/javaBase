package com.chen.algorithm.study.test20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 错误
 *
 * @author :  chen weijie
 * @Date: 2019-09-05 23:10
 */
public class Solution1 {


    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }

        if ("".equals(s)) {
            return true;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty() || map.get(stack.pop()) != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void testCase() {

        System.out.println(isValid("(]"));

    }


}
