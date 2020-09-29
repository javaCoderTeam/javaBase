package com.chen.algorithm.study.test79;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2019-11-24 18:11
 */
public class Solution {


    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        if (m * n == 0) {
            return false;
        }

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(int x, int y, char[][] board, String word, Integer index) {

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;
        if (dfs(x - 1, y, board, word, index + 1) || dfs(x + 1, y, board, word, index + 1)
                || dfs(x, y - 1, board, word, index + 1) || dfs(x + 1, y, board, word, index + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }


    @Test
    public void testCase() {

        char[][] nums = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "SEE";

        System.out.println(exist(nums, word));


    }


}
