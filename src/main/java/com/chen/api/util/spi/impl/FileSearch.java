package com.chen.api.util.spi.impl;

import com.chen.api.util.spi.Search;

import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-06-15 11:04
 */
public class FileSearch implements Search {

    @Override
    public List<String> search(String word) {
        System.out.println("now use file system search. keyword:" + word);
        return null;
    }
}
