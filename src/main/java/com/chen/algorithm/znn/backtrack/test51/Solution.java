package com.chen.algorithm.znn.backtrack.test51;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例：
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * @Auther: zhunn
 * @Date: 2020/11/02 21:23
 * @Description: N皇后问题
 */
public class Solution {

    private boolean[] col; // 列
    private boolean[] master; // 主对角线
    private boolean[] slave; //副对角线
    private int n; // 行数
    private List<List<String>> res; //结果集

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

    private void helper(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (col[i] || master[row + i] || slave[row - i + n - 1]) {
                continue;
            }
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

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            char[] row = new char[n];
            for (int i = 0; i < n; i++) {
                row[i] = '*';
            }
            row[num] = 'Q';
            board.add(row.toString());
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
