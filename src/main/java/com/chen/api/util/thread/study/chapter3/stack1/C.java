package com.chen.api.util.thread.study.chapter3.stack1;

/**
 * @author chen weijie
 * @date 2018-05-10 1:10 AM
 */
public class C {

    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        while (true) {
            myStack.pop();
        }

    }

}
