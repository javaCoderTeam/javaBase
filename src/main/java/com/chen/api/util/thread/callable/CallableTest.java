package com.chen.api.util.thread.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author :  chen weijie
 * @Date: 2018-05-31 00:32
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println("程序开始执行。。。。");
        Date date1 = new Date();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Callable c = new MyCallable(i + "");
            Future<Object> future = pool.submit(c);
            list.add(future);
        }


        pool.shutdown();

        for (Future f : list) {

            System.out.println("result:" + f.get().toString());
        }

        Date date2 = new Date();

        System.out.println("程序结束用时：" + (date2.getTime() - date1.getTime()));


    }


    static class MyCallable implements Callable<Object> {

        private String taskNum;

        MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println("taskNum" + taskNum + "任务启动。");
            Date date = new Date();
            Thread.sleep(1000);
            Date date2 = new Date();
            long time = date2.getTime() - date.getTime();
            System.out.println("任务终止：" + taskNum);
            return taskNum + "任务返回运行结果，当前任务用时：" + time + "ms";
        }
    }


}
