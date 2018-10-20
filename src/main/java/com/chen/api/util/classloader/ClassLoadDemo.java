package com.chen.api.util.classloader;

/**
 * 类加载的实例
 * @author :  chen weijie
 * @Date: 2018-10-19 11:34 AM
 */
public class ClassLoadDemo {

    static {
        System.out.println("ClassLoadDemo静态初始化块执行了");
    }

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader loader = ClassLoadDemo.class.getClassLoader();
        System.out.println(loader);

        //loader.loadClass()来加载类，不会执行静态初始化模块
        loader.loadClass("com.chen.algorithm.bsearch.Bsearch");
        //class.forName加载，默认回执行静态初始化模块
        Class.forName("com.chen.algorithm.bsearch.Bsearch");
        // 使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class.forName("com.chen.algorithm.bsearch.Bsearch",false,loader);




    }



}
