package com.chen.dataStructure.study.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :  chen weijie
 * @Date: 2019-08-15 11:40
 */
public class HashSetTest {


    public static void main(String[] args) {

        //集合求交集
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        set2.retainAll(set1);
        System.out.println(set2);

    }


}
