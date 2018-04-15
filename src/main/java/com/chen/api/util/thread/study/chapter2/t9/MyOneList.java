package com.chen.api.util.thread.study.chapter2.t9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen weijie
 * @date 2018-04-16 12:50 AM
 */
public class MyOneList {

    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }

}
