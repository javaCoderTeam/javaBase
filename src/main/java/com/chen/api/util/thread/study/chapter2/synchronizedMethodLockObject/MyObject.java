package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject;

/**
 * 调用关键字synchronize声明的方法一定时排队运行的,只有共享的资源的读写才需要同步化.
 *
 * @author chen weijie
 * @date 2018-04-12 2:10 AM
 */
public class MyObject {

    //加不加 synchronize
   synchronized public void methodA() {

        System.out.println("begin methodA thread==" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
