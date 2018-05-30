package com.chen.api.util.thread.study.chapter5.timerTest1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 某一时刻开始，每隔N秒执行一次，无限循环的执行某一任务
 *
 * @author Chen WeiJie
 * @date 2018-05-30 21:05:00
 **/
public class Run3 {


    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("执行了任务：" + System.currentTimeMillis() / 1000);
        }
    }

    public static void main(String[] args) {

        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateStr = "2018-05-30 21:11:30";
        try {
            timer.schedule(task, sdf.parse(dateStr), 4000);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


}
