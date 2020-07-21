package com.chen.api.util.queue;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * @author :  chen weijie
 * @Date: 2020-06-11 16:54
 */
public class BlockQueue {


    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        queue.add(1);
        queue.offer(10);
        queue.put(3);

        Integer d = queue.peek();
        Integer f = queue.element();
        Integer c = queue.remove();
        Integer b = queue.poll();
        Integer a = queue.take();


        PriorityBlockingQueue<Student> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.put(new Student(1));
        priorityBlockingQueue.put(new Student(12));
        priorityBlockingQueue.put(new Student(13));


    }


    static class Student implements Comparator<Student> {

        private Integer age;

        public Student(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

}
