package com.chen.dataStructure.self.hash;

/**
 *  线性探测
 * @author :  chen weijie
 * @Date: 2019-04-14 00:56
 */
public class MyHashTable {

    /**
     * DataItem类，表示每个数据项信息
     */
    private DataItem [] hashArray;

    /**
     * 数组的初始大小
     */
    private int arraySize;

    /**
     * 数组实际存储了多少项数据
     */
    private int itemNum;


    /**
     * 用于删除数据项
     */
    private DataItem nonItem;


    public MyHashTable(int arraySize){
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        //删除的数据项下标为-1
        nonItem = new DataItem(-1);
    }

    /**
     * 判断数组是否存储满了
     */
    public boolean isFull(){
        return (itemNum == arraySize);
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return (itemNum == 0);
    }

    //打印数组内容
    public void display(){
        System.out.println("Table:");
        for(int j = 0 ; j < arraySize ; j++){
            if(hashArray[j] != null){
                System.out.print(hashArray[j].getKey() + " ");
            }else{
                System.out.print("** ");
            }
        }
    }

    //通过哈希函数转换得到数组下标
    public int hashFunction(int key) {
        return key % arraySize;
    }


    /**
     * 查找关键值
     *
     * @param key
     * @return
     */
    public DataItem find(int key) {

        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    /**
     * 插入数据项
     *
     * @param item
     */
    public void insert(DataItem item) {

        if (isFull()) {
            //扩展哈希表
            System.out.println("哈希表已满，重新哈希化...");
            extendHashTable();
        }


        int key = item.getKey();
        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        itemNum++;
    }

    /**
     * 数组有固定的大小，而且不能扩展，所以扩展哈希表只能另外创建一个更大的数组，然后把旧数组中的数据插到新的数组中。
     * 但是哈希表是根据数组大小计算给定数据的位置的，所以这些数据项不能再放在新数组中和老数组相同的位置上。
     * 因此不能直接拷贝，需要按顺序遍历老数组，并使用insert方法向新数组中插入每个数据项。
     * 这个过程叫做重新哈希化。这是一个耗时的过程，但如果数组要进行扩展，这个过程是必须的。
     */
    public void extendHashTable() {

        int num = arraySize;
        //重新计数，因为下面要把原来的数据转移到新的扩张的数组中
        itemNum = 0;
        arraySize *= 2;
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];

        for (int i = 0; i < num; i++) {
            insert(oldHashArray[i]);
        }
    }

    /**
     * 删除元素
     *
     * @param key
     * @return
     */
    public DataItem delete(int key) {
        if (isEmpty()) {
            System.out.println("Hash Table is Empty!");
            return null;
        }

        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                itemNum--;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }


    public static class DataItem {

        private int iData;

        public int getKey() {
            return iData;
        }

        public DataItem(int iData) {
            this.iData = iData;
        }
    }
}
