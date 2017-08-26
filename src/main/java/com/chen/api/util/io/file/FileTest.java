package com.chen.api.util.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class FileTest {

    @Test
    public void test(){

        File file = new File("E:\\data\\logs\\vertxStudy.log");

        System.out.println("=====" + file.getName());

    }

}
