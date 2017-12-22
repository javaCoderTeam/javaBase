package com.chen.api.util.reflection.ClassMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 测试主类
 *
 * @author Chen WeiJie
 * @date 2017-12-22 12:33
 **/
public class Main {


    public static Sub makeInstance(Class<?> clazz) {

        Sub sub = null;
        try {
            sub = (Sub) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return sub;

    }


    public static void printBasicInfo(Class<?> clazz) {

        System.out.println("CanonicalName:" + clazz.getCanonicalName());
        System.out.println("simpleName:" + clazz.getSimpleName());
        System.out.println("AnnotatedSuperclass:" + clazz.getAnnotatedSuperclass());

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println("Interface SimpleName : "
                    + inter.getSimpleName());
        }

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> cons : constructors) {
            System.out.println("Constructor Name : " + cons.getName()
                    + " And Parameter Count : " + cons.getParameterCount());
        }

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            System.out.println("Method Name : " + method.getName());
        }


        System.out.println("AnnotatedSuperclass:" + clazz.getAnnotatedSuperclass());
    }

    public static void main(String[] args) {

        //Sub sub = new Sub();
        //Class<?> clazz = sub.getClass();
        Class<?> clazz = Sub.class;
        Sub instance = makeInstance(clazz);
        if (instance != null) {
            System.out.println("make instance successful");
        } else {
            System.out.println("make instance unsuccessful");
        }
        printBasicInfo(clazz);
    }

}
