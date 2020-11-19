package com.chen.algorithm.znn.heap.test347;

import org.junit.Test;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 前 K 个高频元素：PriorityQueue-小根堆
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // 计算频次
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(key -> map.get(key)));
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(queue.peek()) < map.get(key)) {
                queue.poll();
                queue.add(key);
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i] = queue.poll();
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {5, 2, 5, 3, 5, 3, 1, 1, 3};
        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }
}
