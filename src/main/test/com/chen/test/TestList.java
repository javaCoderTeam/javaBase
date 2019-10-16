package com.chen.test;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.util.*;

/**
 * @author :  chen weijie
 * @Date: 2019-05-16 18:14
 */
public class TestList {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(10);

        String a, b, c = null;

        a = b = "test";

        System.out.println(a);
        System.out.println(b);

    }


    @Test
    public void testSetRetainAllCase() {


        Set<Integer> partSet = new HashSet<>();
        partSet.addAll(Arrays.asList(1, 2, 3, 4, 5));

        Set<Integer> allSet = new HashSet<>();
        allSet.addAll(Arrays.asList(2, 3, 4, 8, 9));


    }


    @Test
    public void testListCase() {


        List<Person> list = new ArrayList<>();
        Person person1 = new Person("zhang1", 10);
        Person person2 = new Person("zhang2", 12);
        Person person3 = new Person("zhang3", 13);
        Person person4 = new Person("zhang4", 14);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);


        List<Person> list2 = new ArrayList<>();
        Person person6 = new Person("zhang1", 10);
        Person person5 = new Person("zhang2", 12);
        Person person7 = new Person("zhang5", 90);

        list2.add(person6);
        list2.add(person5);
        list2.add(person7);

        list.retainAll(list2);

        System.out.println(JSONObject.toJSONString(list));


    }

    @Test
    public void testNum() {
        int n = 3667089 % 400;
        System.out.println(n);
    }


    @EqualsAndHashCode
    @Data
    class Person {


        private String name;

        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }


}
