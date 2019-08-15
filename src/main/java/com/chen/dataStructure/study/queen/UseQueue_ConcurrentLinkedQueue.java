package com.chen.dataStructure.study.queen;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author :  chen weijie
 * @Date: 2019-08-14 23:03
 */
public class UseQueue_ConcurrentLinkedQueue {


    public static void main(String[] args) {


        /**
         * Add()和offer()都是加入元素的方法（在ConcurrentLinkedQueue中，这两个方法投有任何区别）
         * Poll()和peek()都是取头元素节点，区别在于前者会删除元素，后者不会。
         */

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5);

        System.out.println("从头部取出元素，并从队列里删除 >> " + queue.poll());
        System.out.println("删除元素后的长度：" + queue.size());
        System.out.println("peek去取元素：" + queue.peek());
        System.out.println("peek后的queue的长度：" + queue.size());

    }


}
