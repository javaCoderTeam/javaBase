package com.chen.algorithm.exercise.exercise5;

/**
 * @author :  chen weijie
 * @Date: 2019-04-16 00:36
 */
public class MyStack {


    int [] elementData;

    int maxSize;

    int top;


    public MyStack(int maxSize){
        elementData = new int[maxSize];
        this.maxSize =maxSize;
        top = -1;
    }


    public int pop(){
        return elementData[top--];
    }


    public void push(int data) {
        if (top < maxSize - 1) {
            elementData[++top] = data;
        }
    }


    public boolean isEmpty() {
        return top == -1;
    }







}
