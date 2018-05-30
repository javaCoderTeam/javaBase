package com.chen.api.util.thread.study.chapter5.timerTest1;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Chen WeiJie
 * @date 2018-05-30 20:42:55
 **/
public class Run2 {

    //定时器，创建一个Timer就是启动一个新的线程。
    private static Timer timer = new Timer();

    //任务块
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("threadName:" + Thread.currentThread().getName() + ",执行了：" + System.currentTimeMillis()/1000);
        }
    }

    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        MyTask task3 = new MyTask();
        MyTask task4 = new MyTask();
        MyTask task5 = new MyTask();
        //TimerTask是以队列的方式顺序执行的，所以执行的时间有可能和预期的时间不一致，因为前面的任务有可能消耗的时间较长，则后面的任务会被顺延。
        timer.schedule(task1,1000);
        timer.schedule(task2,9000);
        timer.schedule(task3,5000);
        timer.schedule(task4,6000);
        timer.schedule(task5,8000);
        System.out.println("开始了：" + System.currentTimeMillis()/1000);
        //在10秒后执行
    }


}
