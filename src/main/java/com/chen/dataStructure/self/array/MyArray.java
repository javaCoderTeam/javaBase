package com.chen.dataStructure.self.array;

/**
 * @author :  chen weijie
 * @Date: 2019-02-26 10:57 PM
 */
public class MyArray {



    //实现 增、删、查、迭代功能

    private int [] intArray;

    /**
     * 数组的元素的个数
     */
    private int elems;

    private int length;

    /**
     * 构造一个长度为50的数组
     */
    public MyArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }


    /**
     * 获取数组的有效长度
     * @return
     */
    public int getSize(){
        return elems;
    }


    /**
     * 遍历数组
     */
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.println(intArray[i] + " ");
        }
    }


    /**
     * 数组中添加元素
     *
     * @param value
     * @return
     */
    public boolean add(int value) {

        if (length == elems) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }


    /**
     * 根据下标获取元素
     * @param i
     * @return
     */
    public int getElems(int i) {

        if (i < 0 || i > elems) {
            System.out.println("数组下标越界");
        }
        return intArray[i];
    }


    /**
     * 查找元素 查找的元素如果存在则返回下标值，如果不存在，返回 -1
     *
     * @return
     */
    public int find(int value) {

        for (int i = 0; i < elems; i++) {
            if (value == intArray[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 如果要删除的值不存在，直接返回 false;否则返回true，删除成功
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {

        int k = find(value);
        if (k == -1) {
            return false;
        } else {
            if (k == elems - 1) {
                elems--;
            } else {
                for (int i = 0; i < elems - 1; i++) {
                    intArray[elems] = intArray[elems + 1];
                }
                elems--;
            }
            return true;
        }
    }


    /**
     * 修改成功返回true，修改失败返回false
     *
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean modify(int oldValue, int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            System.out.println("需要修改的数据不存在");
            return false;
        } else {
            intArray[i] = newValue;
            return true;
        }

    }

    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        myArray.add(1);
        myArray.add(12);
        myArray.add(13);
        myArray.add(14);
        myArray.add(15);

        myArray.display();
        System.out.println("find 12:" + myArray.find(12));
        System.out.println("find 10:" + myArray.find(10));
        myArray.delete(10);
        System.out.println("get i=2 :" + myArray.getElems(2));
        System.out.println("size:" + myArray.getSize());
    }

}
