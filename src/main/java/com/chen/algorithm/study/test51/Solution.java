package com.chen.algorithm.study.test51;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 *
 * @author :  chen weijie
 * @Date: 2020-05-17 02:44
 */
public class Solution {


    private boolean[] col;
    private boolean[] master;
    private boolean[] slave;
    private int n;
    private List<List<String>> res;


    public List<List<String>> solveNQueues(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        col = new boolean[n];
        master = new boolean[2 * n - 1];
        slave = new boolean[2 * n - 1];
        Stack<Integer> stack = new Stack<>();
        helper(0, stack);
        return res;
    }


    public void helper(int row, Stack<Integer> stack) {

        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                stack.push(i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;
                helper(row + 1, stack);
                slave[row - i + n - 1] = false;
                master[row + i] = false;
                col[i] = false;
                stack.pop();
            }
        }
    }

    public List<String> convert2board(Stack<Integer> stack, int n) {

        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append("*");
            }
            sb.replace(num, num + 1, "Q");
            board.add(sb.toString());
        }
        return board;
    }


    @Test
    public void testCase() {
        List<List<String>> res = solveNQueues(4);

        for (List<String> re : res) {
            System.out.println("====" + JSONObject.toJSONString(re));
        }

    }


}
