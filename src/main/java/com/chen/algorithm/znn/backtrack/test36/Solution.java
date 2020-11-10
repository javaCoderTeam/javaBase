package com.chen.algorithm.znn.backtrack.test36;

import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/solution/javawei-yun-suan-1ms-100-li-jie-fang-ge-suo-yin-by/
 * 36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 13:54
 * @Description: 有效的数独：1-哈希数组；2-位运算数组
 */
public class Solution {

    /**
     * 1-哈希数组
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int tmp = board[i][j] - '0';
                if (rows[i].contains(tmp) //本行中已有数字
                        || cols[j].contains(tmp) //本列中已有数字
                        || boxes[(i / 3) * 3 + j / 3].contains(tmp)) //本方格中已有数字
                    return false;
                rows[i].add(tmp); //添加到本行
                cols[j].add(tmp); //添加到本列
                boxes[(i / 3) * 3 + j / 3].add(tmp); //添加到本方格
            }
        }
        return true;
    }

    /**
     * 2-位运算数组
     */
    public boolean isValidSudoku2(char[][] board) {
        int[] rows = new int[9]; //行的位运算数组
        int[] cols = new int[9]; //列的位运算数组
        int[] boxes = new int[9]; //方格的位运算数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int tmp = board[i][j] - '0';
                int boxIndex = i / 3 * 3 + j / 3;
                if ((rows[i] >> tmp & 1) == 1 //rows[i] >> tmp & 1取出第i行的tmp数字，看是否已填，如果等于1，代表已填
                        || (cols[j] >> tmp & 1) == 1 //cols[j] >> tmp & 1取出第j列的tmp数字，看是否已填，如果等于1，代表已填
                        || (boxes[boxIndex] >> tmp & 1) == 1) //boxes[boxIndex] >> tmp & 1取出第boxIndex个方格的tmp数字，看是否已填，如果等于1，代表已填
                    return false;
                rows[i] = rows[i] | (1 << tmp); //将tmp数字加入到第i行的位运算数组
                cols[j] = cols[j] | (1 << tmp); //将tmp数字加入到第j列的位运算数组
                boxes[boxIndex] = boxes[boxIndex] | (1 << tmp); //将tmp数字加入到第boxIndex个方格的位运算数组
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        int[][] row = new int[9][10];   // 哈希表存储每一行的每个数是否出现过，默认初始情况下，每一行每一个数都没有出现过
        // 整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
        int[][] col = new int[9][10];   // 存储每一列的每个数是否出现过，默认初始情况下，每一列的每一个数都没有出现过
        int[][] box = new int[9][10];   // 存储每一个box的每个数是否出现过，默认初始情况下，在每个box中，每个数都没有出现过。整个board有9个box。
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                // 遍历到第i行第j列的那个数,我们要判断这个数在其所在的行有没有出现过，
                // 同时判断这个数在其所在的列有没有出现过
                // 同时判断这个数在其所在的box中有没有出现过
                int curNum = board[i][j] - '0';
                if (row[i][curNum] == 1) {
                    return false;
                }
                if (col[j][curNum] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][curNum] == 1) {
                    return false;
                }
                row[i][curNum] = 1; // 之前都没出现过，现在出现了，就给它置为1，下次再遇见就能够直接返回false了。
                col[j][curNum] = 1;
                box[j / 3 + (i / 3) * 3][curNum] = 1;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean res = isValidSudoku(board);
        System.out.println(res);
    }
}
