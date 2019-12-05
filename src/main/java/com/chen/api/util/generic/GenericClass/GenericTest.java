package com.chen.api.util.generic.GenericClass;

/**
 * @author Chen WeiJie
 * @date 2019-12-04 17:15:47
 **/
public class GenericTest {


    public static void main(String[] args) {

        //在实例化泛型类时，必须指定T的具体类型
        Generic<Integer> generic = new Generic<>(123);
        Generic<String> genericStr = new Generic<>("221");
        System.out.println("泛型测试 key is " + generic.getKey());
        System.out.println("泛型测试 key is " + genericStr.getKey());

    }

}
