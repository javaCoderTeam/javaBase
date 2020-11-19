package com.chen.algorithm.znn.stack.test155;

import org.junit.Test;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @Auther: zhunn
 * @Date: 2020/10/26 18:20
 * @Description: 最小栈
 */
public class Solution {

    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    public void push(Integer value) {
        stack.push(value);  // 元素存入基础栈

        if (minStack.isEmpty() || value < minStack.peek()) {    // 元素满足条件就存入最小栈，比最小栈栈顶元素小也存入
            minStack.push(value);
        }
    }

    public void pop() {

        if (stack.pop().equals(minStack.peek())) {  // 删除基础栈 栈顶元素，如果最小栈栈顶元素等于被删除的元素，一并删除。
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();  // 取出的是基础栈的栈顶元素
    }

    public int getMin() {
        return minStack.peek();     // 获取的是最小栈的栈顶元素
    }

    @Test
    public void test() {
        Solution minStack = new Solution();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int minRes = minStack.getMin();
        System.out.println(minRes);
        minStack.pop();
        int topRes = minStack.top();
        System.out.println(topRes);
        int minRes2 = minStack.getMin();
        System.out.println(minRes2);
    }
}
