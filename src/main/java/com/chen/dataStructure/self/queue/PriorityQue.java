package com.chen.dataStructure.self.queue;

/**
 * @author :  chen weijie
 * @Date: 2019-03-07 12:51 AM
 */
public class PriorityQue {


    private int maxSize;

    private int[] priQueArray;

    private int nItems;


    public PriorityQue(int s) {
        this.maxSize = s;
        this.priQueArray = new int[maxSize];
        this.nItems = 0;
    }


    /**
     * 元素是否满了
     *
     * @return
     */
    public boolean isFull() {
        return maxSize == nItems;
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
     * 查看优先级最高的元素
     *
     * @return
     */
    public int peekMin() {
        return priQueArray[nItems - 1];
    }

    public void insert(int value) {

        if (maxSize == nItems) {
            System.out.println("队列已满！");
        }

        int j = 0;

        if (nItems == 0) {
            priQueArray[nItems++] = value;
        } else {
            //选择的排序方法是插入排序，按照从大到小的顺序排列，越小的越在队列的顶端
            while (j >= 0 && value > priQueArray[j]) {
                priQueArray[j + 1] = priQueArray[j];
                j--;
            }
        }
        priQueArray[j + 1] = value;
        nItems++;
    }

    //移除数据,由于是按照大小排序的，所以移除数据我们指针向下移动
    //被移除的地方由于是int类型的，不能设置为null，这里的做法是设置为 -1
    public int remove() {

        int k = nItems - 1;
        int value = priQueArray[k];
        priQueArray[k] = -1;
        nItems--;
        return value;
    }


}
