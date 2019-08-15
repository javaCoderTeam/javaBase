package com.chen.dataStructure.study.set.treeset;

import java.util.TreeSet;

/**
 * 自然排序  首先，我们通过JDK提供的对象来展示，我们使用String、Integer：
 *
 * @author :  chen weijie
 * @Date: 2019-08-15 15:52
 */
public class TreeSetGeneralSortTest {


    public static void main(String[] agrs) {
        naturalSort();
    }

    //自然排序顺序：升序
    public static void naturalSort() {
        TreeSet<String> treeSetString = new TreeSet<String>();
        treeSetString.add("a");
        treeSetString.add("z");
        treeSetString.add("d");
        treeSetString.add("b");
        System.out.println("字母顺序：" + treeSetString.toString());

        TreeSet<Integer> treeSetInteger = new TreeSet<Integer>();
        treeSetInteger.add(1);
        treeSetInteger.add(24);
        treeSetInteger.add(23);
        treeSetInteger.add(6);
        System.out.println("数字顺序：" + treeSetInteger.toString());
    }


}
