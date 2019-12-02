package com.chen.api.util.reflection.field;

import java.lang.reflect.Field;

/**
 * @author :  chen weijie
 * @Date: 2019-10-23 00:07
 */
public class Test {


    private String testName = "hello";

    public String getTestName() {
        return testName;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class<?> clazz = Test.class;
        Class<?> clazz2 = Class.forName("com.chen.api.util.reflection.field.Test");
        Test test = new Test();
        Class<?> clazz3 = test.getClass();

        Field field = clazz3.getDeclaredField("testName");
        field.setAccessible(true);
        field.set(test, "nihao");

        System.out.println("testName:" + test.getTestName());


    }


}
