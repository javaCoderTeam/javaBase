package com.chen.api.util.lock;

/**
 * @Author chenweijie
 * @Date 2017/9/17 1:39
 */
public class SyncThread implements Runnable {

    private Object obj1;
    private Object obj2;

    public SyncThread(Object o1, Object o2) {
        this.obj1 = o1;
        this.obj2 = o2;
    }


    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + obj1);
        synchronized (obj1) {
            System.out.println(name + " acquiring lock on " + obj1);
            work();
            System.out.println(name + " acquiring lock on " + obj2);
            synchronized (obj2) {
                System.out.println(name + " acquiring lock on " + obj2);
                work();
            }
            System.out.println(name + " acquiring lock on " + obj2);

        }
        System.out.println(name + " released lock on " + obj1);
        System.out.println(name + " finished execution.");
    }

    private void work() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
