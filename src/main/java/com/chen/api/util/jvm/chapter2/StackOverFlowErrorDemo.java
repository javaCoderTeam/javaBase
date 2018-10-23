package com.chen.api.util.jvm.chapter2;

/**
 * 虚拟机栈和本地方法栈内存溢出测试
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xss300k
 * @author :  chen weijie
 * @Date: 2018-10-23 10:00 AM
 */
public class StackOverFlowErrorDemo {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackOverFlowErrorDemo oom = new StackOverFlowErrorDemo();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
