package com.chen.api.util.thread.study.chapter3.stack1;

/**
 * @author chen weijie
 * @date 2018-05-10 1:10 AM
 */
public class P {

    private MyStack myStack;

    public P(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
       while (true){
           myStack.push();
       }
    }


}
