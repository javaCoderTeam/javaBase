package com.chen.algorithm.znn.recursion.HanNuoTa;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: zhunn
 * @Date: 2020/11/2 10:12
 * @Description: 汉诺塔问题
 */
public class HanNuoTa {
    /**
     * 将 A 上的所有盘子，借助 B，移动到C 上
     *
     * @param A 原柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    private void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        if (num == 1) {    // 只剩一个盘子时，直接移动即可
            target.add(original.remove(original.size() - 1));
            return;
        }

        movePlate(num - 1, original, target, auxiliary);   // 将 size-1 个盘子，从 original 移动到 auxiliary
        target.add(original.remove(original.size() - 1));   // 将 第size个盘子，从 original 移动到 target
        movePlate(num - 1, auxiliary, original, target);   // 将 size-1 个盘子，从 auxiliary 移动到 target
    }

    @Test
    public void test() {
        List<Integer> listA = new LinkedList<>();
        listA.add(4);
        listA.add(3);
        listA.add(2);
        listA.add(1);
        List<Integer> listB = new LinkedList<>();
        List<Integer> listC = new LinkedList<>();
        hanota(listA, listB, listC);
        System.out.println(listC);
    }
}
