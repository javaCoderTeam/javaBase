package com.chen.api.util.thread.study.chapter2.synBlockingString2;

/**
 * 对象监视器不同,所以运行结果就是异步的.
 *
 * @author chen weijie
 * @date 2018-04-15 2:26 AM
 */
public class Service {

    private String anyString = new String();

    public void a() {

        try {
            synchronized (anyString) {
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                Thread.sleep(3000);
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void b() {

        System.out.println("b begin");
        System.out.println("b end");
    }


}
