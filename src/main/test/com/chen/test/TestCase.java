package com.chen.test;

import org.junit.Test;

/**
 * User: chenweijie
 * Date: 10/23/17
 * Time: 8:25 PM
 * Description:
 */
public class TestCase {


    @Test
    public void test() {
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY = (1 << COUNT_BITS) - 1;

        final int RUNNING = -1 << COUNT_BITS;
        final int SHUTDOWN = 0 << COUNT_BITS;
        final int STOP = 1 << COUNT_BITS;
        final int TIDYING = 2 << COUNT_BITS;
        final int TERMINATED = 3 << COUNT_BITS;


    }





}
