package com.chen.api.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-05-08 16:54
 */
public class SplitList {


    public static <T> List<List<T>> partList(List<T> source, int n) {

        if (source == null) {
            return null;
        }

        if (n == 0) {
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();
        // 集合长度
        int size = source.size();
        // 余数
        int remaider = size % n;
        System.out.println("余数:" + remaider);
        // 商
        int number = size / n;
        System.out.println("商:" + number);

        for (int i = 0; i < number; i++) {
            List<T> value = source.subList(i * n, (i + 1) * n);
            result.add(value);
        }

        if (remaider > 0) {
            List<T> subList = source.subList(size - remaider, size);
            result.add(subList);
        }
        return result;


    }

    /**
     * 将待邀请的成员列表分成n个组
     *
     * @param source
     * @param n
     * @return
     */
    private <T>List<List<T>> splitList(List<T> source, int n) {


        List<List<T>> result = new ArrayList<>();
        //(先计算出余数)
        int remaider = source.size() % n;
        //然后是商
        int number = source.size() / n;
        //偏移量
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> value;
            if (remaider > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;

    }

}
