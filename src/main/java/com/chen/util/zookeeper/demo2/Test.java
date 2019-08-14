package com.chen.util.zookeeper.demo2;

/**
 * @author :  chen weijie
 * @Date: 2019-06-10 18:17
 */
public class Test {

    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                DistributedLock2 lock2 = null;
                try {

                    lock2 = new DistributedLock2("127.0.0.1:2182,127.0.0.1:2183,127.0.0.1:2184", "test");

                    lock2.lock();
                    Thread.sleep(1000);
                    secskill();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (lock2 != null) {
                        lock2.unlock();
                    }
                }
            }).start();


        }


    }


}
