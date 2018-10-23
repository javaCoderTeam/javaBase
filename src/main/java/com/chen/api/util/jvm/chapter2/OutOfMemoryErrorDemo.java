package com.chen.api.util.jvm.chapter2;

        import java.util.ArrayList;
        import java.util.List;

/**
 * java 堆用于存储对象实例，只要不断的创建，并且保证GC ROOTs到对象之间有可达路径来避免垃圾回收机制清楚这些对象，name对象达到最大堆的容量限制后就会产生内存溢出异常
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * @author :  chen weijie
 * @Date: 2018-10-23 9:20 AM
 */
public class OutOfMemoryErrorDemo {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
