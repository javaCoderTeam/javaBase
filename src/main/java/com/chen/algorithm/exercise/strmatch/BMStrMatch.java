package com.chen.algorithm.exercise.strmatch;

/**
 * 字符匹配算法
 *
 * @author :  chen weijie
 * @Date: 2020-05-01 15:23
 */
public class BMStrMatch {

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[b.length]; // 记录模式串中每个字符最后出现的位置
//        generateBC(b, m, bc); // 构建坏字符哈希表
        int i = 0; // i表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }

}
