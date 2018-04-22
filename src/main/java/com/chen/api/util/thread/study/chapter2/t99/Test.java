package com.chen.api.util.thread.study.chapter2.t99;

/**
 * @author chen weijie
 * @date 2018-04-22 8:02 PM
 */
public class Test {

    public static void main(String[] args) {
        PrintString printString = new PrintString();
        printString.printStringMethod();
        System.out.println("我要停止它");
        printString.setContinuePrint(false);
    }

}
