package com.chen.dataStructure.study.queen;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author :  chen weijie
 * @Date: 2019-08-15 00:13
 */
public class DequeTest {


    public static void main(String[] args) {


        LinkedBlockingDeque<String> dq = new LinkedBlockingDeque<String>(10);
        dq.addFirst("a");
        dq.addFirst("b");
        dq.addFirst("c");
        dq.addFirst("d");
        dq.addFirst("e");
        dq.addLast("f");
        dq.addLast("g");
        dq.addLast("h");
        dq.addLast("i");
        dq.addLast("j");
        //dq.offerFirst("k");
        System.out.println("查看头元素：" + dq.peekFirst());
        System.out.println("获取尾元素：" + dq.pollLast());
        Object [] objs = dq.toArray();
        for (int i = 0; i < objs.length; i++) {
            System.out.print(objs[i] + " -- ");
        }

    }

}
