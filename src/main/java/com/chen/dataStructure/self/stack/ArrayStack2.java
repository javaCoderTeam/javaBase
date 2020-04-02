package com.chen.dataStructure.self.stack;

/**
 * @author Chen WeiJie
 * @date 2020-03-30 11:02:05
 **/
public class ArrayStack2 {


    private int[] elements;

    private int capacity;

    private int size;


    public ArrayStack2(int n) {

        this.elements = new int[n];
        this.capacity = n;
        this.size = 0;
    }


    public void push(int element) {
        elements[++size] = element;
    }


    public int pop() {
        int element = elements[--size];
        return element;
    }


}
