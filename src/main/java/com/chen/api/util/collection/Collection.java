package com.chen.api.util.collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * list sort
 * Created by chenwj3 on 2017/1/17.
 */
public class Collection {

    private static final Logger LOGGER = LogManager.getLogger(Collection.class);

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(14);
        list.add(16);
        list.add(43);
        list.add(1);
        LOGGER.info("list sort before :{}",list);
        //对list进行排序
        Collections.sort(list);
        LOGGER.info("list sort after :{}",list);

    }


}
