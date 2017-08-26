package com.chen.api.util.base;

import org.junit.Test;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class StringBufferTest {

    @Test
    public void testCapacity(){


        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("test");

        System.out.println("capacity:"+stringBuffer.capacity());
        System.out.println("length:"+stringBuffer.length());
    }


}
