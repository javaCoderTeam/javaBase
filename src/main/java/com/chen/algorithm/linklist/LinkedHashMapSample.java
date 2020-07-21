package com.chen.algorithm.linklist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :  chen weijie
 * @Date: 2020-06-01 17:24
 */
public class LinkedHashMapSample {

    public static void main(String[] args) {
        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, false) {
            // 实现自定义删除策略，否则行为就和普遍 Map 没有区别
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 模拟访问
        accessOrderedMap.get("Project1");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project1");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 触发删除
        accessOrderedMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed:");
        // 遍历顺序不变
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
