package com.chen.util.zookeeper.demo3;

/**
 * @author :  chen weijie
 * @Date: 2019-06-10 18:41
 */
public class Test {



    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                ZooKeeperDistributedLock lock2 = null;
                try {

                    lock2 = new ZooKeeperDistributedLock(n+"");
                    lock2.acquireDistributedLock();
                    System.out.println(Thread.currentThread().getName()+"获取到锁了。。。。");
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
