package com.chen.algorithm.study.test347;

import org.junit.Test;

import java.util.*;

/**
 * @author :  chen weijie
 * @Date: 2020-09-19 15:10
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });


        for (int num : map.keySet()) {

            if (queue.size() < k) {
                queue.add(num);
            } else if (map.get(queue.peek()) < map.get(num)) {
                queue.remove();
                queue.add(num);
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }

        return res;
    }

    @Test
    public void testCase() {

        int[] nums = {5, 2, 5, 3, 5, 3, 1, 1, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

}
