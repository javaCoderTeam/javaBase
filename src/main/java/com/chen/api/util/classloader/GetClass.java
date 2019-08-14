package com.chen.api.util.classloader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author :  chen weijie
 * @Date: 2019-06-02 02:26
 */
public class GetClass {


    public static void printClassMethodMessage(Object obj) {
        //要获取类的信息》》首先我们要获取类的类类型
        Class c = obj.getClass();
        //我们知道Object类是一切类的父类，所以我们传递的是哪个子类的对象，c就是该子类的类类型。
        //接下来我们要获取类的名称
        System.out.println("类的名称是:" + c.getName());
        /*
         *我们知道，万事万物都是对象，方法也是对象，是谁的对象呢？
         * 在java里面，方法是Method类的对象
         *一个成员方法就是一个Method的对象，那么Method就封装了对这个成员
         *方法的操作
         */
        //如果我们要获得所有的方法，可以用getMethods()方法，这个方法获取的是所有的Public的函数，包括父类继承而来的。如果我们要获取所有该类自己声明的方法，就可以用getDeclaredMethods()方法，这个方法是不问访问权限的。
        Method[] ms = c.getMethods();//c.getDeclaredMethods()
        //接下来我们拿到这些方法之后干什么？我们就可以获取这些方法的信息，比如方法的名字。
        //首先我们要循环遍历这些方法
        for (Method m : ms) {
            //然后可以得到方法的返回值类型的类类型
            Class returnType = m.getReturnType();
            //得到方法的返回值类型的名字
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(m.getName() + "(");
            //获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = m.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException {

        Class<?> clazz = HelloWorld.class;


        HelloWorld helloWorld = (HelloWorld) clazz.newInstance();



        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getMethod("wait", long.class));
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            Class<?> classType = field.getType();
            String name = field.getName();
            System.out.println(classType);
            System.out.println(name);
            System.out.println(field);
        }


//        printClassMethodMessage(new HelloWorld());
    }

}
