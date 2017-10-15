package com.chen.api.util.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author chenweijie
 * @Date 2017/9/20 23:19
 */
public class ReaderWriterList<T> {


    private ArrayList<T> lockedList;

    private ReentrantReadWriteLock lock =new ReentrantReadWriteLock(true);

    public ReaderWriterList(int size,T initialValue){
        lockedList =new ArrayList<T>(Collections.nCopies(size,initialValue));
    }






}
