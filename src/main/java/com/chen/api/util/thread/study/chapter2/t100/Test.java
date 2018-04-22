package com.chen.api.util.thread.study.chapter2.t100;

/**
 * @author chen weijie
 * @date 2018-04-22 8:08 PM
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        PrintString printString = new PrintString();
        new Thread(printString).start();
        Thread.sleep(1000);
        System.out.println("想要停止它...");
        printString.setContinuePrint(false);

    }

}
