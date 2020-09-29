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
public class Solution3 {

    class SlidWindow {

        ArrayDeque<Integer> deque;

        public SlidWindow(){
            deque = new ArrayDeque<>();
        }

        public Integer getMax (){
            return  deque.peekFirst();
        }

        public void push(int val){

            while (!deque.isEmpty() && deque.peekLast() < val) {
                deque.pollLast();
            }
            deque.addLast(val);
        }


        public void pop(int val) {
            if (!deque.isEmpty() && deque.peekFirst() == val) {
                deque.pollFirst();
            }
        }



    }

    public int [] maxSlidingWindow(int [] nums, int k){

        if (nums == null || nums.length < k){
            return new int[0];
        }
        ArrayList<Integer> resList = new ArrayList<>();
        SlidWindow slidWindow = new SlidWindow();

        for (int i = 0; i < nums.length; i++) {
            if (i < k-1){
                slidWindow.push(nums[i]);
            }else {
                slidWindow.push(nums[i]);
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
