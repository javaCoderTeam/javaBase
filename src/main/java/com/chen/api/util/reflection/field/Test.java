package com.chen.api.util.reflection.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author :  chen weijie
 * @Date: 2019-10-23 00:07
 */
public class Test {

    public Test(){
        System.out.println("无参构造器 Run...........");
    }


    private String testName = "hello";

    public String getTestName() {
        return testName;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Test.class;
        Class<?> clazz2 = Class.forName("com.chen.api.util.reflection.field.Test");
        Test test = new Test();
        Class<?> clazz3 = test.getClass();

        Field field = clazz3.getDeclaredField("testName");
        field.setAccessible(true);
        field.set(test, "nihao");

        Constructor<?> constructor1 = clazz3.getConstructor();
        Test test1 = (Test) constructor1.newInstance();

        System.out.println("testName:" + test1.getTestName());


    }


}
