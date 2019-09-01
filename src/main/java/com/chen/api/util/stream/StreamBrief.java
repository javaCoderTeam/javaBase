package com.chen.api.util.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Chen Weijie on 2017/8/13.
 */

public class StreamBrief {


//构造流的几种常见方法
//    // 1. Individual values
//    Stream stream = Stream.of("a", "b", "c");
//    // 2. Arrays
//    String [] strArray = new String[] {"a", "b", "c"};
//    stream = Stream.of(strArray);
//    stream = Arrays.stream(strArray);
//    // 3. Collections
//    List<String> list = Arrays.asList(strArray);
//    stream = list.stream();


    @Test
    public void createStream() {

        List<Integer> list = Arrays.asList(1, 2, 3, 6, 9, 35, 2, 1, 3, 4, 5, 6, 79, 90);
        list.stream()
                .mapToInt(x -> x * x)
                .filter(x -> x % 2 != 0)
                .map(x -> x * x).skip(1).limit(3)
                .forEach(System.out::println);
    }


    // 流转换为其它数据结构
//    // 1. Array
//    String[] strArray1 = stream.toArray(String[]::new);
//    // 2. Collection
//    List<String> list1 = stream.collect(Collectors.toList());
//    List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
//    Set set1 = stream.collect(Collectors.toSet());
//    Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
//    // 3. String
//    String str = stream.collect(Collectors.joining()).toString();

    @Test
    public void transFormStream() {

        List<Integer> list = Arrays.asList(1, 2, 3, 6, 9);
        Stream<Integer> stream = list.stream();
        Integer[] strArray = stream.toArray(Integer[]::new);
        List<Integer> list1 = stream.collect(Collectors.toCollection(LinkedList::new));
        List<Integer> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
    }


    @Test
    public void testFlatMap() {

        List<Integer> list1 = Arrays.asList(1);
        List<Integer> list2 = Arrays.asList(1, 3, 5);
        List<Integer> list3 = Arrays.asList(2, 4, 6);

        Stream<List<Integer>> stream = Stream.of(list1, list2, list3);
        Stream<Integer> outStream = stream.flatMap(Collection::stream);
        outStream.collect(Collectors.toSet()).forEach(System.out::println);
    }


    @Test
    public void testPeak() {

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    @Test
    public void testReduce() {

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }


    @Test
    public void testMatch() {


        List<Person> persons = new ArrayList();
        persons.add(new Person(1, "name" + 1, 10));
        persons.add(new Person(2, "name" + 2, 21));
        persons.add(new Person(3, "name" + 3, 34));
        persons.add(new Person(4, "name" + 4, 6));
        persons.add(new Person(5, "name" + 5, 55));
        boolean isAllAdult = persons.stream().
                allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = persons.stream().
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);


    }


    public static class Person {
        public int no;
        private String name;
        private int age;

        public Person(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
