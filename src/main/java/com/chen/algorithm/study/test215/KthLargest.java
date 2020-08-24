package com.chen.algorithm.study.test215;

import java.util.PriorityQueue;

/**
 * @author :  chen weijie
 * @Date: 2020-05-04 16:37
 */
public class KthLargest {


    public PriorityQueue<Integer> queue = null;
    private Integer limit = null;


    public KthLargest(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < limit) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }


}
