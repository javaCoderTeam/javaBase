package com.chen.algorithm.study.test239;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/dan-diao-dui-lie-by-labuladong/
 * @author :  chen weijie
 * @Date: 2020-09-19 19:43
 */
public class Solution1 {

    private class MonotonicQueue {

        ArrayDeque<Integer> deque;

        public MonotonicQueue() {
            deque = new ArrayDeque<>();
        }

        public Integer max() {
            return deque.peekFirst();
        }

        public void pop(int num) {
            if (!deque.isEmpty() && num == deque.peekFirst()) {
                deque.pollFirst();
            }
        }

        public void push(int num) {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue windows = new MonotonicQueue();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                windows.push(nums[i]);
            } else {
                windows.push(nums[i]);
                res.add(windows.max());
                windows.pop(nums[i - k + 1]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    @Test
    public void testCase() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] res = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(res));


    }

}
