package com.chen.algorithm.rectangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: chenweijie
 * Date: 11/6/17
 * Time: 9:46 PM
 * Description: http://www.cnblogs.com/flamebird/p/6840382.html
 */
public class TestSnakeCircle {

    //判断N是偶数还是奇数，N为偶数时num=count,为奇数时num = count-1
    public static void getArray(int num,int count){
        ArrayList<ArrayList> listAll = new ArrayList<ArrayList>(count);//二维Arraylist
        if(num != count){//奇数时先构建最核心的1
            ArrayList start = new ArrayList(count);
            start.add(1);
            listAll.add(start);
        }
        for(int i=0;i<num/2;i++){
            ArrayList listHead = new ArrayList();//构建要加的第一行
            ArrayList listEnd = new ArrayList();//构建要加的最末行
            int k;
            if(num !=count)
                k = 2*i+3;
            else
                k = 2*i+2;
            for(int j=0;j<k;j++){
                listHead.add(k*k-j);//填充要加的第一行
                listEnd.add((k-2)*(k-2)+k-1+j);//填充要加的最末行
                if(j<(k-2)){//原有的每行加头加尾
                    ArrayList listTem = new ArrayList();
                    listTem = listAll.get(j);
                    listTem.add(0,(k-2)*(k-2)+1+j);
                    listTem.add(k*k-k-j);
                    listAll.set(j,listTem);
                }
            }
            listAll.add(0,listHead);//加入第一行
            listAll.add(listEnd);//加入最末行
        }
//输出
        for(int i=0;i<count;i++){
            ArrayList listTem = new ArrayList();
            listTem = listAll.get(i);
            for(Iterator iter = listTem.iterator(); iter.hasNext();){
                int lastValue = count*count+1 - (int)iter.next();
//没有标准化格式的输出
//                System.out.print(lastValue+" ");
                System.out.printf("%3d ",lastValue);
            }
            System.out.println();
        }
    }

    @Test
    public void test(){
        getArray(4,5);
    }
}
