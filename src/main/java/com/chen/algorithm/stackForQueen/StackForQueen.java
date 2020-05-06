package com.chen.algorithm.stackForQueen;

import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-04-28 18:29
 */
public class StackForQueen {


    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();


    public void push(Integer value) {
        stack1.push(value);
    }


    public Integer pop() {

        if (stack2.isEmpty() && stack1.isEmpty()) {
            return null;
        }


        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();


    }


}
