package com.chen.api.util.generic.GenericClass;

/**
 * 泛型类，是在实例化类的时候指明泛型的具体类型；
 * <p>
 * 泛型方法，是在调用方法的时候指明泛型的具体类型。
 *
 * @author Chen WeiJie
 * @date 2019-12-04 17:12:50
 **/
public class Generic<T> {


    private T key;


    public Generic(T key) {
        this.key = key;
    }


    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }


}
