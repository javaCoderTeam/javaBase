package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2019-06-01 19:12
 */
public final class ScannerTest {


    public String  userName;

    public Integer age;


    public static void main(String[] args) {


        Integer a = 127;
        Integer b =127;

        System.out.println(a==b);

        Integer c = 128;
        Integer d =128;

        System.out.println(c==d);


    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
