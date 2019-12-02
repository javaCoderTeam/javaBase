package com.chen.api.util.reflection.anonotation;

import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;

/**
 * @author :  chen weijie
 * @Date: 2019-10-23 00:14
 */
@Controller
public class Test {


    public static void main(String[] args) {

        Test test = new Test();

        Class<?> clazz = test.getClass();
        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation annotation : annotations) {

            System.out.println(annotation);
        }


    }

}
