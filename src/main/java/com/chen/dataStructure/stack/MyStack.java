package com.chen.dataStructure.stack;

/**
 * @author :  chen weijie
 * @Date: 2019-03-05 11:47 PM
 */
public class MyStack {


    /**
     * 栈的实际元素
     */
    private int[] array;

    /**
     * 指向栈顶的指针
     */
    private int top;

    /**
     * 栈的容量
     */
    private int maxSize;


    public MyStack(int size) {
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }


    /**
     * 插入元素
     *
     * @param value
     */
    public void push(int value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        }
    }


    /**
     * 弹出元素
     *
     * @return
     */
    public int pop() {
        return array[top--];
    }


    /**
     * 访问栈顶元素
     *
     * @return
     */
    public int peep() {
        return array[top];
    }


    /**
     * 栈是否是空
     *
     * @return
     */
    public boolean isEmpty() {
        return (top == -1);
    }


    /**
     * @return
     */
    public boolean isFull() {
        return (maxSize - 1) == top;
    }


    public static void main(String[] args) {

        MyStack myStack = new MyStack(4);

        myStack.push(10);
        myStack.push(20);
        myStack.push(1);
        myStack.push(-1);

        System.out.println("isFull:" + myStack.isFull());
        System.out.println("peek:" + myStack.peep());

        while (!myStack.isEmpty()) {
            System.out.println("弹出：" + myStack.pop());
            System.out.println("栈内元素个数：" + myStack.top);
        }
    }


}
