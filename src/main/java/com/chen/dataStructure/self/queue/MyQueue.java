package com.chen.dataStructure.self.queue;

/**
 * @author :  chen weijie
 * @Date: 2019-03-07 12:13 AM
 */
public class MyQueue {

    private Object[] queArray;

    /**
     * 队列总大小
     */
    private int maxSize;

    /**
     * 前端
     */
    private int front;

    /**
     * 后端
     */
    private int fear;

    /**
     * 队列中实际元素个数
     */
    private int nItems;

    public MyQueue(int s) {
        this.maxSize = s;
        this.queArray = new Object[maxSize];
        front = 0;
        fear = -1;
        nItems = 0;
    }


    /**
     * 返回队列的大小
     *
     * @return
     */
    public int getSize() {
        return nItems;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return nItems == 0;
    }


    /**
     * 队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return maxSize == nItems;
    }

    /**
     * 查看队头元素
     *
     * @return
     */
    public Object peekFront() {
        return queArray[front];
    }


    /**
     * 移除元素
     *
     * @return
     */
    public Object remove() {

        Object removeValue = null;
        if (!isEmpty()) {
            removeValue = peekFront();
            front++;
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }



    /**
     * 队列中新增元素
     *
     * @param value
     */
    public void insert(Object value) {

        if (isFull()) {
            System.out.println("队列已满！！！");
        } else {
            if (fear == maxSize - 1) {
                fear = -1;
            }
            //队尾指针加1，然后在队尾指针处插入新的数据
            queArray[++fear] = value;
            nItems++;
        }
    }


    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(4);

        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);

        //获取队头元素
        System.out.println("myQueue.peekFront():" + myQueue.peekFront());

        //移除元素
        myQueue.remove();

        //插入元素
        myQueue.insert(50);
        myQueue.insert(60);

        for (Object a : myQueue.queArray) {
            System.out.println("a:" + a);
        }
    }




}
