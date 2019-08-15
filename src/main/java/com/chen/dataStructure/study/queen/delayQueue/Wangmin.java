package com.chen.dataStructure.study.queen.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author :  chen weijie
 * @Date: 2019-08-14 23:58
 */
public class Wangmin implements Delayed {


    private String name;
    //身份证
    private String id;
    //截止时间
    private long endTime;
    //定义时间工具类
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public Wangmin(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {

        Wangmin w = (Wangmin) o;
        return this.getDelay(timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1 : 0;
    }
}
