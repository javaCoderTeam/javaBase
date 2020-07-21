package com.chen.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :  chen weijie
 * @Date: 2020-06-08 17:44
 */
public class AcPersonServiceTest {

    public static void main(String[] args) {

        System.out.println("开始初始化容器");
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("xml加载完毕");
        Person person1 = (Person) ac.getBean("person1");
        System.out.println(person1);
        System.out.println("关闭容器");
        ((ClassPathXmlApplicationContext) ac).close();


    }

}
