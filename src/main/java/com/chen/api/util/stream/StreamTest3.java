package com.chen.api.util.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author :  chen weijie
 * @Date: 2019-09-01 18:49
 */
public class StreamTest3 {


    public static void main(String[] args) {


        //demo1
        String[] strs = {"1", "5", "7", "9"};

        Stream<String> stream = Stream.of(strs);

        stream.sorted((o1, o2) -> {
            if (o1.compareTo(o2) > 0) {
                return 1;
            } else {
                return -1;
            }
        });

//        List<String> stringList = stream.sorted().collect(Collectors.toCollection(ArrayList::new));


        // demo2
        Integer[] integers = {4, 5, 6, 8, 10, -3};
        int max = Stream.of(integers).max((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        }).get();
        System.out.println("max = " + max);

        // demo3
        Integer[] integers2 = {4, 5, 6, 8, 10, -3};
        Long count = Stream.of(integers2).count();
        System.out.println("count = " + count);


        // demo4
        // BinaryOperator接口，可以看到reduce方法接受一个函数，这个函数有两个参数，第一个参数是上次函数执行的返回值（也称为中间结果），
        // 第二个参数是stream中的元素，这个函数把这两个值相加，得到的和会被赋值给下次执行这个函数的第一个参数。要注意的是：第一次执行的时候第一个参数的值是Stream的第一个元素，
        // 第二个参数是Stream的第二个元素。这个方法返回值类型是Optional，
        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult.get());
        System.out.println("--------");


    }


}
