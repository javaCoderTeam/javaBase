package com.chen.api.util.classloader;

/**
 * 类加载器的获取
 *
 * @author :  chen weijie
 * @Date: 2018-10-19 11:22 AM
 */
public class HelloWorld {


    /**
     * 三、类加载的一般过程
     * 原理：双亲委托模式
     * 1、寻找jre目录，寻找jvm.dll，并初始化JVM；
     * 2、产生一个Bootstrap Loader（启动类加载器）；
     * 3、Bootstrap Loader自动加载Extended Loader（标准扩展类加载器），并将其父Loader设为Bootstrap Loader。
     * 4、Bootstrap Loader自动加载AppClass Loader（系统类加载器），并将其父Loader设为Extended Loader。
     * 5、最后由AppClass Loader加载HelloWorld类。
     * <p>
     * 四、类加载器的特点
     * 1、运行一个程序时，总是由AppClass Loader（系统类加载器）开始加载指定的类。
     * 2、在加载类时，每个类加载器会将加载任务上交给其父，如果其父找不到，再由自己去加载。
     * 3、Bootstrap Loader（启动类加载器）是最顶级的类加载器了，其父加载器为null.
     */

    public static void main(String[] args) {

        HelloWorld hello = new HelloWorld();
        Class<?> c = hello.getClass();
        ClassLoader classLoader = c.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        // 获取不到其父类，因为其父类是用C语言写的，找不到一个确定的返回父Loader的方式
        System.out.println(classLoader.getParent().getParent());



    }


}
