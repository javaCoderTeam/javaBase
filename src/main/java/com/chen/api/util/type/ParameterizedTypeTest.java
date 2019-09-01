package com.chen.api.util.type;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * @author :  chen weijie
 * @Date: 2019-08-18 00:15
 */
public class ParameterizedTypeTest<T> {


    private List<T> list = null;

    private Set<T> set = null;

    public static void main(String[] args) throws NoSuchFieldException {

        Field fieldList = ParameterizedTypeTest.class.getDeclaredField("list");

        Type typeList = fieldList.getGenericType();

        System.out.println(typeList.getClass().getName());





    }


}
