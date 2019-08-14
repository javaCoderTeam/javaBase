package com.chen.api.util.thread.threadLocal;

import java.util.Random;

/**
 * @author :  chen weijie
 * @Date: 2019-05-28 23:50
 */
public class ThreadLocalDemo implements Runnable {


    private final static ThreadLocal<Student> studentLocal = new ThreadLocal();


    @Override
    public void run() {
        accessStudent();
    }


    public static void main(String[] args) {

        ThreadLocalDemo td = new ThreadLocalDemo();

        Thread threadA = new Thread(td, "a");
        threadA.start();
        Thread threadB = new Thread(td, "b");
        threadB.start();
    }


    /**
     * 获取学生的信息
     */
    protected void accessStudent() {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + "is running");

        Random random = new Random();

        int age = random.nextInt(100);

        System.out.println("thread " + currentThreadName + " set age to:" + age);
        //获取一个Student对象，并将随机数年龄插入到对象属性中
        Student student = getStudent();
        student.setAge(age);

        System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());

    }


    /**
     * 获取学生
     *
     * @return Student
     */
    protected Student getStudent() {

        Student student = studentLocal.get();

        if (student == null) {
            student = new Student();
            studentLocal.set(student);
        }

        return student;
    }


}
