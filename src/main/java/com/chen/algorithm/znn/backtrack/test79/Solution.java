package com.chen.algorithm.znn.backtrack.test79;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 18:31
 * @Description: 单词搜索
 */
public class Solution {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, word, board, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int index, String word, char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length //越界
                || word.charAt(index) != board[x][y] // 字符不相等
                || visited[x][y]) {  // 被访问过
            return false;
        }
        if (index == word.length() - 1) { // 已验证到单词结尾
            return true;
        }

        visited[x][y] = true;
        if (dfs(index + 1, word, board, x - 1, y) || dfs(index + 1, word, board, x + 1, y)
                || dfs(index + 1, word, board, x, y - 1) || dfs(index + 1, word, board, x, y + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }

    @Test
    public void test() {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

}
