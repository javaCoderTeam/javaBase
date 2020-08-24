package com.chen.algorithm.fooBarThread;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-08-04 17:28
 */
public class TestCase {

    @Test
    public void testCase() {

        SynchronizedFooBar fooBar = new SynchronizedFooBar();
        fooBar.setN(10);

        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

}
