package com.chen.api.util.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Chen Weijie on 2017/8/4.
 */
public class ReflectionTest1 {



    @Test
    public void testGetClassWays(){
        Class<?> demo1 =null;
        Class<?> demo2 =null;
        Class<?> demo3 =null;

        try {
            demo1 =Class.forName("com.chen.api.util.reflection.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        demo2 =new Demo().getClass();

        demo3 =Demo.class;

        System.out.println("类名称1   "+demo1.getName());
        System.out.println("类名称2   "+demo2.getName());
        System.out.println("类名称3   "+demo3.getName());


    }



    @Test
    public void testSuperClass() throws ClassNotFoundException {

        Class<?> demo1 = Class.forName("com.chen.api.util.reflection.Demo");

        Class<?> superClass = demo1.getSuperclass();
        System.out.println("superClass:" + superClass.getName());

    }


    @Test
    public void testConstructors() throws ClassNotFoundException {

        Class<?> demo1 = Class.forName("com.chen.api.util.reflection.Demo");
        Constructor<?> [] constructors =demo1.getConstructors();
        for (Constructor<?> constructor :constructors){
            System.out.println(constructor);
        }

    }

    @Test
    public void testFields() throws ClassNotFoundException {

        Class<?> demo1 = Class.forName("com.chen.api.util.reflection.Demo");


        Field [] fields=demo1.getDeclaredFields();

        for (Field field :fields){
            String name =field.getName();
            int mo =field.getModifiers();
            Class<?> type=field.getType();
            System.out.println("name:"+name);
            System.out.println("getModifiers:"+ Modifier.toString(mo));
            System.out.println("type:"+type);
        }

    }

    @Test
    public void testMethods() throws Exception{

        Class<?> demo1 = Class.forName("com.chen.api.util.reflection.Demo");
        Demo demo = (Demo) demo1.newInstance();
        demo.setAge(10);
        Method [] methods =demo1.getMethods();

        for (Method method :methods){
            String methodNamd =method.getName();
            System.out.println("methodNamd:"+methodNamd);
        }

    }

    @Test
    public void testNewInstance() throws Exception{

        Class<?> demo1 = Class.forName("com.chen.api.util.reflection.Demo");
        Demo demo = (Demo) demo1.newInstance();
        demo.setAge(10);

        System.out.println(demo);

    }





}
