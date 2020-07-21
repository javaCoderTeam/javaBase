package com.chen.algorithm.study.test155;

import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/min-stack-fu-zhu-stackfa-by-jin407891080/
 *
 * @author :  chen weijie
 * @Date: 2019-11-02 16:51
 */
public class Solution {


    class MinStack {


        private Stack<Integer> stack;

        private Stack<Integer> min_stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {

            stack.push(x);

            if (min_stack.isEmpty() || x <= min_stack.peek()) {
                min_stack.push(x);
            }
        }

        public void pop() {

            if (stack.pop().equals(min_stack.peek())) {
                min_stack.pop();
            }
        }


        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }

        public Stack<Integer> getStack() {
            return stack;
        }

        public void setStack(Stack<Integer> stack) {
            this.stack = stack;
        }

        public Stack<Integer> getMin_stack() {
            return min_stack;
        }

        public void setMin_stack(Stack<Integer> min_stack) {
            this.min_stack = min_stack;
        }
    }


    @Test
    public void testCase() {
        MinStack minStack = new MinStack();

        int[] array = {10, 6, 7, 2, 11};

        for (int i : array) {
            minStack.push(i);
        }

        while (!minStack.getStack().isEmpty()) {
            System.out.println("取出元素后：" + minStack.top());
            minStack.pop();
            System.out.println(minStack.getMin());

        }

    }


}
