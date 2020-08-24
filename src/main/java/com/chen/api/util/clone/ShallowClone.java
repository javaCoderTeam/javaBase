package com.chen.api.util.clone;

/**
 * https://www.cnblogs.com/qian123/p/5710533.html
 *
 * @author :  chen weijie
 * @Date: 2020-07-23 16:02
 */
public class ShallowClone {


    public static void main(String args[]) {
        Student stu1 = new Student();
        stu1.setNumber(12345);
        Student stu2 = (Student)stu1.clone();

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        stu2.setNumber(54321);

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());
    }


}
