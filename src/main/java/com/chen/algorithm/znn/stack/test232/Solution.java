package com.chen.algorithm.znn.stack.test232;

import java.util.Stack;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 17:36
 * @Description: 用栈实现队列
 */
public class Solution {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(Integer value) {
        stack1.push(value);
    }

    public Integer pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public Integer peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
