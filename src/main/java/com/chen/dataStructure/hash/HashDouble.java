package com.chen.dataStructure.hash;

/**
 * 再hash算法
 * @author :  chen weijie
 * @Date: 2019-04-14 01:34
 */
public class HashDouble {

    private DataItem[] hashArray;   //DataItem类，表示每个数据项信息
    private int arraySize;//数组的初始大小
    private int itemNum;//数组实际存储了多少项数据
    private DataItem nonItem;//用于删除数据项

    public HashDouble(){
        this.arraySize = 13;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);//删除的数据项下标为-1
    }

    public static class DataItem{
        private int iData;
        public DataItem(int iData){
            this.iData = iData;
        }
        public int getKey(){
            return iData;
        }
    }

    //判断数组是否存储满了
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
    public int hashFunction1(int key){
        return key%arraySize;
    }

    public int hashFunction2(int key){
        return 5 - key%5;
    }

    /**
     * 数组有固定的大小，而且不能扩展，所以扩展哈希表只能另外创建一个更大的数组，然后把旧数组中的数据插到新的数组中。
     * 但是哈希表是根据数组大小计算给定数据的位置的，所以这些数据项不能再放在新数组中和老数组相同的位置上。
     * 因此不能直接拷贝，需要按顺序遍历老数组，并使用insert方法向新数组中插入每个数据项。
     * 这个过程叫做重新哈希化。这是一个耗时的过程，但如果数组要进行扩展，这个过程是必须的。
     */
    public void extendHashTable(){
        int num = arraySize;
        itemNum = 0;//重新计数，因为下面要把原来的数据转移到新的扩张的数组中
        arraySize *= 2;//数组大小翻倍
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];
        for(int i = 0 ; i < num ; i++){
            insert(oldHashArray[i]);
        }
    }

    //插入数据项
    public void insert(DataItem item){
        if(isFull()){
            //扩展哈希表
            System.out.println("哈希表已满，重新哈希化...");
            extendHashTable();
        }
        int key = item.getKey();
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);//用第二个哈希函数计算探测步数
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            hashVal += stepSize;
            hashVal %= arraySize;//以指定的步数向后探测
        }
        hashArray[hashVal] = item;
        itemNum++;
    }


    //删除数据项
    public DataItem delete(int key){
        if(isEmpty()){
            System.out.println("Hash Table is Empty!");
            return null;
        }
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;//nonItem表示空Item,其key为-1
                itemNum--;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    //查找数据项
    public DataItem find(int key){
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }




}
