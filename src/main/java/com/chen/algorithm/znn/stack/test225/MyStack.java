package com.chen.algorithm.znn.stack.test225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 22:20
 * @Description: 用两个队列实现一个栈, 官方解法
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int value) {
        q2.offer(value);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
