package com.chen.api.util.thread.study.chapter5.timerTest1;

/**
 * scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
 * schedule 和scheduleAtFixedRate主要区别在于不延时的情况，
 * schedule如果执行的任务没有被延时，那么下一次任务的执行时间参考的执行时间是上一次任务“开始”的时间来计算。
 * scheduleAtFixedRate 如果执行的任务没有被延时，那么下一次任务的执行时间参考的执行时间是上一次任务“结束”的时间来计算。
 * 
 * 延时的情况则没有区别，都是按照结束的时间来计算
 *
 * @author Chen WeiJie
 * @date 2018-05-30 21:27:37
 **/
public class Run6 {

}

