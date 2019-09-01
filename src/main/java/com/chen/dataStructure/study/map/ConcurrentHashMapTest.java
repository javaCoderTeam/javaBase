package com.chen.dataStructure.study.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author :  chen weijie
 * @Date: 2019-09-01 15:38
 */
public class ConcurrentHashMapTest {


    public static void main(String[] agrs) throws InterruptedException {

        final HashMap<String, String> map = new HashMap<>();

        Thread t = new Thread(() -> {

            for (int x = 0; x < 10000; x++) {
                Thread tt = new Thread(() -> map.put(UUID.randomUUID().toString(), ""));
                tt.start();
                System.out.println(tt.getName());
            }
        });
        t.start();
        t.join();
    }


}
