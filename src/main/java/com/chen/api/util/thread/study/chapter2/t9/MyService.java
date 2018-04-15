package com.chen.api.util.thread.study.chapter2.t9;

import com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject.MyObject;

/**
 * 出现脏读后,可以在list参数上添加synchronized锁
 *
 * @author chen weijie
 * @date 2018-04-16 12:52 AM
 */
public class MyService {

    public MyOneList addServiceMethod(MyOneList list, String data) {

        synchronized (list) {
            if (list.getSize() < 1) {
                try {
                    Thread.sleep(200);//模拟从远处获取数据
                    list.add(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
