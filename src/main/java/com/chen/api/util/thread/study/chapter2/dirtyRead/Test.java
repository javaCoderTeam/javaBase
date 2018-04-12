package com.chen.api.util.thread.study.chapter2.dirtyRead;

/**
 * @author chen weijie
 * @date 2018-04-13 12:05 AM
 */
public class Test {

    public static void main(String[] args) {

        PublicVar var = new PublicVar();
        ThreadA threadA = new ThreadA(var);
        threadA.start();
        try {
            Thread.sleep(1000);//打印结果受值大小影响此影响(如果getValue方法不加synchronize关键字)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var.getValue();
    }

}
