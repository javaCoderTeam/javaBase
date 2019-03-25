package com.chen.api.util.thread.threadPool;

import java.util.concurrent.*;

/**
 * @author :  chen weijie
 * @Date: 2019-03-19 12:02 AM
 */
public class ThreadPoolTest {


    static class MyTask implements Runnable {

        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;

        }

        @Override
        public void run() {


            System.out.println("正在执行task " + taskNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }


    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 20, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 50; i++) {
            MyTask t = new MyTask(i);
            try {
                threadPool.execute(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程池中线程数目：" + threadPool.getPoolSize() + "，队列中等待执行的任务数目：" +
                    threadPool.getQueue().size() + "，已执行玩别的任务数目：" + threadPool.getCompletedTaskCount());
        }

        threadPool.shutdown();
    }


}
