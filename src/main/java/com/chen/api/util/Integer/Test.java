package com.chen.api.util.Integer;

/**
 * 关于Integer比较大小的问题(http://www.blogjava.net/zhangyuan/archive/2010/07/24/327011.html)
 *
 * @author Chen WeiJie
 * @date 2018-01-17 15:55
 **/
public class Test {


    @org.junit.Test
    public void test() {

        Integer a = 10;
        Integer b = 10;
        System.out.println("a==b : " + String.valueOf(a == b));
        System.out.println("a.equals(b) : " + String.valueOf(a.equals(b)));

    }


    @org.junit.Test
    public void test2() {

        Integer a = 1000;
        Integer b = 1000;
        System.out.println("a==b : " + String.valueOf(a == b));
        System.out.println("a.equals(b) : " + String.valueOf(a.equals(b)));

    }

}
