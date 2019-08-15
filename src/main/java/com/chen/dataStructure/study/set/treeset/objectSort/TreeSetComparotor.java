package com.chen.dataStructure.study.set.treeset.objectSort;

import java.util.Comparator;

/**
 * @author :  chen weijie
 * @Date: 2019-08-15 15:59
 */
public class TreeSetComparotor implements Comparator<TreeSetObject> {


    @Override
    public int compare(TreeSetObject o1, TreeSetObject o2) {

        if (o1.getAge() > o2.getAge()) {
            return 1;
        }

        return 0;
    }
}
