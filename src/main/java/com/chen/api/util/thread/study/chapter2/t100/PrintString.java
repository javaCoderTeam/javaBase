package com.chen.api.util.thread.study.chapter2.t100;

/**
 * @author chen weijie
 * @date 2018-04-22 8:07 PM
 */
public class PrintString implements Runnable {


    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }


    @Override
    public void run() {

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
