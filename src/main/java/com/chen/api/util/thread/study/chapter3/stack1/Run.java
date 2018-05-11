package com.chen.api.util.thread.study.chapter3.stack1;

/**
 * @author chen weijie
 * @date 2018-05-10 1:13 AM
 */
public class Run {


    public static void main(String[] args) {
        MyStack myStack =new MyStack();

        C c =new C(myStack);
        P p =new P(myStack);

        ThreadC threadC =new ThreadC(c);
        ThreadP threadP =new ThreadP(p);

        threadP.start();
        threadC.start();
    }



}
