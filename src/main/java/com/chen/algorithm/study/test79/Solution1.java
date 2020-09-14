package com.chen.algorithm.study.test79;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 *
 * @author :  chen weijie
 * @Date: 2020-09-15 01:47
 */
public class Solution1 {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 递归终止条件就判断了 word.charAt(0) == board[i][j]
                // if (word.charAt(0) == board[i][j]) {
                if (dfs(0, board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int index, char[][] board, String word, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || word.charAt(index) != board[x][y] || visited[x][y]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        if (dfs(index + 1, board, word, x + 1, y) ||
                dfs(index + 1, board, word, x - 1, y) ||
                dfs(index + 1, board, word, x, y + 1) ||
                dfs(index + 1, board, word, x, y - 1)) {
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
