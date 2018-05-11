package com.chen.api.util.thread.study.chapter3.p_r_test;

/**
 * @author chen weijie
 * @date 2018-05-10 12:38 AM
 */
public class C {

    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){

        try {
            synchronized (lock){
                if (ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get 的值是:"+ValueObject.value);
                ValueObject.value="";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
