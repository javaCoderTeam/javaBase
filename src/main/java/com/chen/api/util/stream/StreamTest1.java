package com.chen.api.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chenwj3 on 2017/5/3.
 */
public class StreamTest1 {



    public static void main(String [] args){

        //filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
        Integer[] integers = {2, 3, 1, 444, 56, 2};
        Stream.of(integers).filter(n -> n % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);


        //我们先来看 map。如果你熟悉 scala 这类函数式语言，对这个方法应该很了解，它的作用就是把 input Stream 的每一个元素，映射成 output Stream 的另外一个元素。
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream(). map(n -> n * n).
                collect(Collectors.toList()).forEach(System.out::println);


        // peek 对每个元素执行操作并返回一个新的 Stream
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        integerList.stream().findAny();

    }

}
