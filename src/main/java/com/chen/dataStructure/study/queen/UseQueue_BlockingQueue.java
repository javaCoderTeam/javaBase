package com.chen.dataStructure.study.queen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author :  chen weijie
 * @Date: 2019-08-14 23:17
 */
public class UseQueue_BlockingQueue {


    public static void main(String[] args) throws InterruptedException {


        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");
        arrayBlockingQueue.add("d");
        arrayBlockingQueue.offer("e");
//        System.out.println(arrayBlockingQueue.offer("f",4, TimeUnit.SECONDS));
        System.out.println("打印数据：" + arrayBlockingQueue.toString());

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();


        linkedBlockingQueue.offer("a");
        linkedBlockingQueue.offer("b");
        linkedBlockingQueue.offer("c");
        linkedBlockingQueue.offer("d");
        linkedBlockingQueue.offer("e");
        linkedBlockingQueue.add("f");

        for (Iterator iterator = linkedBlockingQueue.iterator(); iterator.hasNext(); ) {
            String string = (String) iterator.next();
            System.out.println(string + " -- ");
        }


        List<String> list = new ArrayList<>();

        linkedBlockingQueue.drainTo(list, 2);

        System.out.println("取出LinkedBlockingQueue数据放到list列表的长度为   >>  " + list.size());
        for (String string : list) {
            System.out.println(string + " -- ");
        }


        System.out.println("--------------- SynchronousQueue --------------");

        SynchronousQueue<String> stringSynchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "取出元素：" + stringSynchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            stringSynchronousQueue.add("3");
            System.out.println(Thread.currentThread().getName() + "加入数据 3");
        }).start();


    }


}
