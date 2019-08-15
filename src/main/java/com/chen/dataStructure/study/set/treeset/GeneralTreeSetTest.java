package com.chen.dataStructure.study.set.treeset;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * treeset的基本方法
 * @author :  chen weijie
 * @Date: 2019-08-15 15:25
 */
public class GeneralTreeSetTest {


    public static void main(String[] args) {


        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println("初始化容量大小" + treeSet.size());

        treeSet.add("my");
        treeSet.add("name");
        treeSet.add("is");
        treeSet.add("jiaboyan");
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        System.out.println("TreeSet容量大小：" + treeSet.size());
        System.out.println("treeset 元素的顺序：" + treeSet.toString());

        for (String str : treeSet) {
            System.out.println("遍历元素：" + str);
        }


        System.out.println("遍历元素升序==============");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("遍历元素升序：" + iterator.next());
        }
        System.out.println("遍历元素升序==============");


        System.out.println("遍历元素降序==============");
        Iterator<String> iteratorDESC = treeSet.descendingIterator();
        while (iteratorDESC.hasNext()) {
            System.out.println("遍历元素降序：" + iteratorDESC.next());
        }
        System.out.println("遍历元素降序==============");

        //元素获取:实现NavigableSet接口
        String firstEle = treeSet.first();
        System.out.println("获取头节点：" + firstEle);

        // 获取指定元素之前的所有元素集合：(不包含指定元素)
        SortedSet<String> headSet = treeSet.headSet("jiaboyan");
        System.out.println("jiaboyan节点之前的元素为：" + headSet.toString());


        //获取给定元素之间的集合：（包含头，不包含尾）
        SortedSet<String> subSet = treeSet.subSet("1", "jiaboyan");
        System.out.println("1--jiaboan之间节点元素为：" + subSet.toString());

        //集合判断：
        boolean isEmpty = treeSet.isEmpty();
        System.out.println("TreeSet是否为空：" + isEmpty);
        boolean isContain = treeSet.contains("who");
        System.out.println("TreeSet是否包含who元素：" + isContain);


        //元素删除：
        boolean jiaboyanRemove = treeSet.remove("jiaboyan");
        System.out.println("jiaboyan元素是否被删除" + jiaboyanRemove);

        //集合中不存在的元素，删除返回false
        boolean whoRemove = treeSet.remove("who");
        System.out.println("who元素是否被删除" + whoRemove);


        //删除并返回第一个元素：如果set集合不存在元素，则返回null
        String pollFirst = treeSet.pollFirst();
        System.out.println("删除的第一个元素：" + pollFirst);

        //删除并返回最后一个元素：如果set集合不存在元素，则返回null
        String pollLast = treeSet.pollLast();
        System.out.println("删除的最后一个元素：" + pollLast);

    }


}
