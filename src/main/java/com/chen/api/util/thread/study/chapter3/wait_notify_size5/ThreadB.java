package com.chen.api.util.thread.study.chapter3.wait_notify_size5;

/**
 * 由输出的日志可以看出，当执行notify方法后，不会立即释放锁，只有方法执行完毕才会释放锁。
 * @author :  chen weijie
 * @Date: 2018-04-24 00:45
 */
public class ThreadB extends Thread {


    private Object object;

    public ThreadB(Object ob) {
        super();
        this.object = ob;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        System.out.println(" notify start===" + System.currentTimeMillis());
                        object.notify();
                        System.out.println("notify end===" + System.currentTimeMillis());
                    }
                    System.out.println("添加了" + (i + 1) + "个元素");

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
