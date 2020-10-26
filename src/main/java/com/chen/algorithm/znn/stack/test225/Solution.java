package com.chen.algorithm.znn.stack.test225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 21:20
 * @Description: 用两个队列实现一个栈
 */
public class Solution {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public void push(Integer value) {
        q1.add(value);
        top = value;
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.peek());
            top = q1.remove();
        }
        int result = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return result;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
