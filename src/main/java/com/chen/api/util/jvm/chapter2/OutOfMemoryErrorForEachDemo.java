package com.chen.api.util.jvm.chapter2;

/**
 * 创建线程导致内存溢出异常
 * 需要将线程栈设置的大些  -Xss2M
 * @author :  chen weijie
 * @Date: 2018-10-23 10:22 AM
 */
public class OutOfMemoryErrorForEachDemo {

    int i =0;

    private void dontStop(){
        while (true){
            i++;
            System.out.println(i);
        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread =new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        OutOfMemoryErrorForEachDemo oom = new OutOfMemoryErrorForEachDemo();
        oom.stackLeakByThread();
    }
}
