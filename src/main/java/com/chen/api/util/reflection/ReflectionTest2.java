package com.chen.api.util.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射测试类
 *
 * @author chen weijie
 * @date 2017-12-08 12:09 AM
 */
public class ReflectionTest2 {

    public static Car initByDefaultConst() throws Throwable {

        //通过类装载器获取car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.chen.api.util.reflection.Car");

        //获取类的默认构造器对象.并通过它实例化car
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        //通过属性方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", Integer.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }


    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();

        System.out.println(car.introduce());
    }


}
