package com.chen.api.util.thread.study.chapter3.twoThreadTransData;

/**
 *
 *
 * @author chen weijie
 * @date 2018-04-23 12:17 AM
 */
public class ThreadB extends Thread {

    private MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("b线程running.....");
            if (list.size() == 5) {
                System.out.println("==5了,线程b要退出了.");
                throw new RuntimeException();
            }
        }
    }

}
