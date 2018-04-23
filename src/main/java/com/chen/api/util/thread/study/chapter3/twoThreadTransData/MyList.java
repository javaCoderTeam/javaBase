package com.chen.api.util.thread.study.chapter3.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen weijie
 * @date 2018-04-23 12:13 AM
 */
public class MyList {


    private List list = new ArrayList();

    public void add() {
        list.add("高");
    }

    public int size() {

        return list.size();
    }

}
