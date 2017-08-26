package com.chen.api.util.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenwj3 on 2017/1/17.
 */
public class MainList {


    @Test
    public void testIterator(){

        List<String> list =new LinkedList<>();
        list.add("test");
        list.add("mongodb");
        list.add("redis");

        Iterator<String> it =list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


}
