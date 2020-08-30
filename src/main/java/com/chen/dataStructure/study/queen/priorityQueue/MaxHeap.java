package com.chen.dataStructure.study.queen.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue 默认实现的是小顶堆，如果传入comparator参数定义排序，则可以实现大顶堆。
 *
 * @author :  chen weijie
 * @Date: 2020-08-30 01:23
 */
public class MaxHeap {

    private int size;

    public PriorityQueue<Integer> queue = new PriorityQueue<>(size, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public MaxHeap(int size, int[] nums) {
        this.size = size;
        for (int n : nums) {
            add(n);
        }
    }


    private Integer add(int val) {

        if (queue.size() < size) {
            queue.offer(val);
        } else if (queue.peek() != null && queue.peek() > val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

}
