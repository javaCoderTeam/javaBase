package com.chen.api.util.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author :  chen weijie
 * @Date: 2020-06-15 11:06
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("hello world");

        ServiceLoader serviceLoader = ServiceLoader.load(Search.class);
        Iterator<Search> searchList = serviceLoader.iterator();
        while (searchList.hasNext()) {
            Search curSearch = searchList.next();
            curSearch.search("test");
        }

    }
}
