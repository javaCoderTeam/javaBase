package com.chen.algorithm.exercise.exercise5;

/**
 * @author :  chen weijie
 * @Date: 2019-04-16 00:44
 */
public class SimilarQueen {


    MyStack stack1 = new MyStack(10);

    MyStack stack2 = new MyStack(10);


    public void push(int data) {
        stack1.push(data);
    }


    public int pop() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("element is empty!");
        }

        //只要栈2不为空就pop。如果栈2位空且栈1不为空，则从栈1中取出放入栈2，然后从栈2中取出。
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


}
