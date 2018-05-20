package com.chen.api.util.thread.study.chapter4.waiitConditionNotufyError;

/**
 * 异常信息为监视器对象报错，在Condition.await()之前调用lock.lock();）
 *
 * @author :  chen weijie
 * @Date: 2018-05-17 00:52
 */
public class Run {


    public static void main(String[] args) {

        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}
