package com.chen.algorithm.study.test239;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/dan-diao-dui-lie-by-labuladong/
 *
 * @author :  chen weijie
 * @Date: 2020-09-19 19:43
 */
public class Solution2 {

    class SlidWindow {

        private ArrayDeque<Integer> deque;

        public SlidWindow() {
            deque = new ArrayDeque<>();
        }


        public Integer getMax() {
            return deque.peekFirst();
        }

        public void push(Integer value) {

            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public void pop(int value) {

            if (!deque.isEmpty() && deque.peekFirst() == value) {
                deque.pollFirst();
            }

        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        SlidWindow slidWindow = new SlidWindow();
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i < k - 1) {
                slidWindow.push(num);
            } else {
                slidWindow.push(num);
                resList.add(slidWindow.getMax());
                slidWindow.pop(nums[i - k + 1]);
            }
        }

        int[] ans = new int[resList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = resList.get(i);
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
