package com.chen.api.util.thread.study.chapter2.synNotExtends;

/**
 * @author chen weijie
 * @date 2018-04-13 1:10 AM
 */
public class Sub extends Main {


    @Override
    public void serviceMethod() {
        System.out.println("int sub 下一步 sleep begin threadName=" + Thread.currentThread().getName() + ",time===" + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("int sub 下一步 sleep end threadName=" + Thread.currentThread().getName() + ",time===" + System.currentTimeMillis());
        super.serviceMethod();
    }
}
