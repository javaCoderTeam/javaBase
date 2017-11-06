package com.chen.algorithm.rectangle;

/**
 * User: chenweijie
 * Date: 11/6/17
 * Time: 9:52 PM
 * Description: http://blog.csdn.net/terry84fun/article/details/4807521
 */
public class RingDemo {
    /**
     * @param n
     * 打印螺旋举矩阵
     */
    public static void setArray(int n) {
        int intA = 1;//初始化
        int[][] array = new int[n][n];
        int intB;
        if (n % 2 != 0) {
            intB = n / 2 + 1;//奇数时i循环次数
        } else
            intB = n / 2;//偶数时i循环次数
        for (int i = 0; i < intB; i++) {//从外到里循环
            //从左到右横的开始
            for (int j = i; j < n - i; j++) {
                array[i][j] = intA;
                intA++;
            }
            //从上到下纵
            for (int k = i + 1; k < n - i; k++) {
                array[k][n - i - 1] = intA;
                intA++;
            }
            //从右到左横
            for (int l = n - i - 2; l >= i; l--) {
                array[n - i - 1][l] = intA;
                intA++;
            }
            //从下到上纵
            for (int m = n - i - 2; m > i; m--) {
                array[m][i] = intA;
                intA++;
            }
        }
        //输出数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void setArray(int n,int m) {
        int intA=1;
        int array[][] = new int[n][m];
        int intB;
        if (n % 2 != 0) {
            intB = n / 2 + 1;//奇数时i循环次数
        } else
            intB = n / 2;//偶数时i循环次数
        for(int i = 0;i < intB; i++){//从外到里循环
            //从左到右横的开始
            for(int j = i; j<m-i; j++)
            {
                array[i][j]=intA;
                intA++;
            }
            //从上到下
            for(int k=i+1;k<n-i;k++)
            {
                array[k][m-i-1]=intA;
                intA++;
            }
            //从右到左
            for(int l=m-i-2; l>=i;l--)
            {
                array[n-i-1][l]=intA;
                intA++;
            }
            //从下到上
            for(int o=n-i-2;o>i;o--)
            {
                array[o][i]=intA;
                intA++;
            }
        }
        //输出数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        setArray(5);
//        setArray(5,6);
    }
}
