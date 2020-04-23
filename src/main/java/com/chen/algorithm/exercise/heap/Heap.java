package com.chen.algorithm.exercise.heap;

/**
 *
 * 堆化非常简单，就是顺着节点所在的路径，向上或者向下，对比，然后交换。
 *
 * 我这里画了一张堆化的过程分解图。我们可以让新插入的节点与父节点对比大小。如果不满足子节点小于等于父节点的大小关系，我们就互换两个节点。一直重复这个过程，直到父子节点之间满足刚说的那种大小关系。
 *
 * @author :  chen weijie
 * @Date: 2020-04-19 18:44
 */
public class Heap {

    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return; // 堆满了
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = i / 2;
        }
    }


    /**
     * 我们把最后一个节点放到堆顶，然后利用同样的父子节点对比方法。对于不满足父子节点大小关系的，
     * 互换两个节点，并且重复进行这个过程，直到父子节点之间满足大小关系为止。这就是从上往下的堆化方法
     */
    public void removeMax() {
        if (count == 0) {
            // 堆中没有数据
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }


    /**
     * 建堆
     *
     * @param a
     * @param n
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 堆排序
     *
     * @param a
     * @param n
     */
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }




    private static void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }


    /**
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }


}
