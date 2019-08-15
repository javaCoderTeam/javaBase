package com.chen.dataStructure.study.set.treeset.objectSort;

import java.util.TreeSet;

/**
 * @author :  chen weijie
 * @Date: 2019-08-15 15:55
 */
public class TreeSetObjectSortTest {


    public static void main(String[] args) {
        customSort();
    }


    public static void customSort() {

        // 对象放入treeSet中必须添加对象比较器
        TreeSet<TreeSetObject> treeSet = new TreeSet<>(new TreeSetComparotor());

        //排序对象：
        TreeSetObject app1 = new TreeSetObject("hello", 10);
        TreeSetObject app2 = new TreeSetObject("world", 20);
        TreeSetObject app3 = new TreeSetObject("my", 15);
        TreeSetObject app4 = new TreeSetObject("name", 25);

        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app4);

        System.out.println("TreeSet集合顺序为：" + treeSet);


    }


}
