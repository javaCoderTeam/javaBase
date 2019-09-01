package com.chen.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-08-29 14:57
 */
public class SplitListTest {


    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(12);
        list.add(22);
        list.add(42);
        list.add(52);
        list.add(62);
        list.add(72);
        list.add(82);
        list.add(92);
        list.add(102);
        list.add(112);
        list.add(122);

        List<List<Integer>> resultList = splitList(list, 5);

        for (List<Integer> integers : resultList) {
            System.out.println(JSONObject.toJSONString(integers));

        }


    }


    /**
     * 将待邀请的成员列表分成n个组
     *
     * @param source
     * @param n
     * @return
     */
    private static List<List<Integer>> splitList(List<Integer> source, int n) {

        List<List<Integer>> result = new ArrayList<>();
        //(先计算出余数)
        int remaider = source.size() % n;
        //然后是商
        int number = source.size() / n;
        //偏移量
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> value;
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
