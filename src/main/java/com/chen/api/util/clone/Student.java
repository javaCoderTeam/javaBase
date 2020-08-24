package com.chen.api.util.clone;

/**
 *
 * 1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常)， 该接口为标记接口(不含任何方法)
 *
 * 2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象。（native为本地方法)
 *
 *
 * # 通过深复制，
 * 序列化就是将对象写到流的过程，写到流中的对象是原有对象的一个拷贝，而原对象仍然存在于内存中。通过序列化实现的拷贝不仅可以复制对象本身，
 * 而且可以复制其引用的成员对象，因此通过序列化将对象写到一个流中，再从流里将其读出来，可以实现深克隆。需要注意的是能够实现序列化的对象其类必须实现Serializable接口，
 * 否则无法实现序列化操作。
 *
 * @author :  chen weijie
 * @Date: 2020-07-23 16:02
 */
public class Student implements Cloneable {

    private int number;

    private Address addr;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try{
            stu = (Student)super.clone(); //浅复制
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        stu.addr = (Address) addr.clone(); //深度复制
        return stu;
    }
}
