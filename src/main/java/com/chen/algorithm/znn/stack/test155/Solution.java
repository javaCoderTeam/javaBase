package com.chen.algorithm.znn.stack.test155;

import java.util.Stack;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 18:20
 * @Description: 最小栈
 */
public class Solution {

    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    public void push(Integer value) {
        stack.push(value);

        if (minStack.isEmpty() || value < minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
