package com.chen.dataStructure.self.stack;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2019-03-06 12:31 AM
 */
public class ArrayStack {


    /**
     * object类型的数组可以存储任意类型
     */
    private Object[] elementData;

    /**
     * 指向栈顶的指针
     */
    private int top;

    /**
     * 栈的容量
     */
    private int size;


    public ArrayStack() {

        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public ArrayStack(int initialCapacity) {

        if (initialCapacity < 0) {
            throw new IllegalArgumentException("栈的初始容量不得小于0：" + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.top = -1;
        this.size = initialCapacity;
    }


    public Object push(Object value) {
        isGrow(top + 1);
        elementData[++top] = value;
        return value;
    }


    public void remove(int top) {

        //栈顶元素置为null
        elementData[top] = null;
        this.top--;
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public Object peek() {

        if (top == -1) {
            return null;
        }
        return elementData[top];

    }


    public Object pop() {
        Object object = peek();
        remove(top);
        return object;
    }


    public boolean isGrow(int minCapacity) {

        int oldCapacity = size;
        //如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
        if (oldCapacity <= minCapacity) {
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1);//左移一位，相当于*2
            }
            this.size = newCapacity;
            int[] newArray = new int[size];
            elementData = Arrays.copyOf(elementData, size);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        //System.out.println(stack.peek());
        stack.push(2);
        stack.push(3);
        stack.push("abc");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());

    }


}
