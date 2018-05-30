package com.chen.api.util.thread.study.chapter5.timerTest1;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Chen WeiJie
 * @date 2018-05-30 20:42:55
 **/
public class Run1 {

    //定时器，创建一个Timer就是启动一个新的线程。
    private static Timer timer = new Timer();

    //任务块
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("执行了：" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("开始了：" + System.currentTimeMillis());
        //在10秒后执行
        timer.schedule(task, 10000);
    }


}
