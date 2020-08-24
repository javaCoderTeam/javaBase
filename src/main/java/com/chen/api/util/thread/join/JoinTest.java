package com.chen.api.util.thread.join;

/**
 * @author :  chen weijie
 * @Date: 2020-07-28 18:25
 */
public class JoinTest {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {

                    try {
                        Thread.sleep(100);
                        System.out.println("==="+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(12345);


    }

}
