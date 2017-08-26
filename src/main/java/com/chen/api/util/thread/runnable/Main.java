package com.chen.api.util.thread.runnable;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class Main {
    public static void main(String[] args) {

        Bank bank =new Bank();
        bank.setNum(300);

        Thread threadOne =new Thread(bank);
        threadOne.setName("one");
        Thread threadTwo =new Thread(bank);
        threadTwo.setName("two");
        threadOne.start();
        threadTwo.start();


    }
}
