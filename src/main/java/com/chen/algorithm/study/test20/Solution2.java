package com.chen.algorithm.study.test20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 初始化栈 S。
 * 一次处理表达式的每个括号。
 * 如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
 * 如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
 * 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
 *
 * @author :  chen weijie
 * @Date: 2019-09-06 00:10
 */
public class Solution2 {


    public boolean isValid(String s) {


        Map<Character, Character> map = new HashMap<>(3);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (Character aChar : chars) {
            if (map.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop().equals(aChar)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }


    @Test
    public void testCase() {

        System.out.println(isValid("[](){}"));

    }

    public static void main(String [] args){

        System.out.println(isValid2("[](){}"));
    }


    public static boolean isValid2(String str){

        Map<Character,Character> map = new HashMap<>(3);
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i<str.length();i++){
            Character c = str.charAt(i);
            if(map.containsKey(c)){
                stack.push(c);
            }else{
                if(!c.equals(map.get(stack.pop()))){
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }






}
