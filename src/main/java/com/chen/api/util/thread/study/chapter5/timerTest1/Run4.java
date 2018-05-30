package com.chen.api.util.thread.study.chapter5.timerTest1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Chen WeiJie
 * @date 2018-05-30 21:16:18
 **/
public class Run4 {


    static public class MyTaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println("a任务开始执行。。");
            //timerTask的方法，将task从定时任务中移除出去
            this.cancel();
        }
    }

    static public class MyTaskB extends TimerTask {
        @Override
        public void run() {
            System.out.println("b任务开始执行。。");
        }
    }


    public static void main(String[] args) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = "2018-05-30 21:21:50";

            MyTaskA taskA = new MyTaskA();
            MyTaskB taskB = new MyTaskB();
            Timer timer = new Timer();

            timer.schedule(taskA, sdf.parse(dateStr),1000);
            timer.schedule(taskB, sdf.parse(dateStr),2000);

            System.out.println("开始执行。。。。。");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


}