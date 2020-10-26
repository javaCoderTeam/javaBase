package com.chen.algorithm.study.test703;

import java.util.PriorityQueue;

/**
 * @author :  chen weijie
 * @Date: 2020-07-27 17:37
 */
public class ObjectPriorityQueue {


    private PriorityQueue<Integer> queue = null;

    private Integer limit = null;


    public ObjectPriorityQueue(int size, Integer[] nums) {
        this.limit = size;
        queue = new PriorityQueue<>(10);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int num) {

        if (queue.size() < limit) {
            queue.offer(num);
        } else if (queue.peek() < num) {
            queue.poll();
            queue.offer(num);
        }

        return queue.peek();
    }


}
