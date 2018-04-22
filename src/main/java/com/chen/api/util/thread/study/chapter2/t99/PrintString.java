package com.chen.api.util.thread.study.chapter2.t99;

/**
 * 这种的情况是停不了的,while是死循环.
 *
 * @author chen weijie
 * @date 2018-04-22 7:58 PM
 */
public class PrintString {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {

        int i = 0;

        while (isContinuePrint) {
            i++;
            try {
                System.out.println("run printStringMethod,thread =" + Thread.currentThread().getName() + ",i==" + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
