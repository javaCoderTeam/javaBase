package com.chen.algorithm.znn.sort;

/**
 * @Auther: zhunn
 * @Date: 2020/10/24 17:23
 * @Description: 排序相关
 */
public class Test {

    /**
     * 冒泡排序 sort/BubbleSort （n2 稳定） *** （了解）
     * 快速排序 sort/QuickSort （nlogn 不稳定）**（重点）
     * 归并排序 sort/MergeSort （nlogn 稳定，非原地排序）（重点）
     * 选择排序 sort/ChoiceSort （n2 稳定） *** (了解)
     * 插入排序 sort/InsertSort (n2 不稳定) ***（熟悉）
     *
     * 堆排序 （根据需要熟悉）
     */

    /*
    一、内部排序：
            1、插入排序：1）直接插入排序
                        2）折半插入排序
                        3）希尔排序
            2、交换排序：1）冒泡排序
                        2）快速排序
            3、选择排序：1）简单选择排序
                        2）堆排序
            4、归并排序
            5、基数排序
    二、外部排序：多路归并排序
     */

    /**
     * https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
     * 十大经典排序算法：https://www.cnblogs.com/onepixel/articles/7674659.html
     * https://www.cnblogs.com/mcgrady/category/396002.html
     * 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
     * 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序
     */

    /**
     * 排序分为以下四类共七种排序方法：
     * 交换排序：
     * 1) 冒泡排序
     * 2) 快速排序
     * 选择排序：
     * 3) 直接选择排序
     * 4) 堆排序
     * 插入排序：
     * 5) 直接插入排序
     * 6) 希尔排序
     * 合并排序：
     * 7) 归并排序
     *
     * 每个排序方法的时间复杂度详细请看链接：https://www.cnblogs.com/onepixel/articles/7674659.html
     *
     * 排序方法	    时间复杂度（平均）   	时间复杂度（最坏)	    时间复杂度（最好)	    空间复杂度	稳定性	复杂性    备注
     * 直接插入排序	O(n2)	            O(n2)	            O(n)	            O(1)	    稳定	    简单      大部分已排序时较好
     * 希尔排序	    O(nlog2n)	        O(n2)	            O(n)	            O(1)	    不稳定	较复杂
     * 直接选择排序	O(n2)	            O(n2)	            O(n2)	            O(1)	    不稳定	简单      n小时较好
     * 堆排序	    O(nlog2n)	        O(nlog2n)	        O(nlog2n)	        O(1)	    不稳定	较复杂    n大时较好
     * 冒泡排序	    O(n2)	            O(n2)	            O(n)	            O(1)	    稳定	    简单      n小时较好
     * 快速排序	    O(nlog2n)	        O(n2)	            O(nlog2n)	        O(nlog2n)	不稳定	较复杂    n大时较好
     * 归并排序	    O(nlog2n)	        O(nlog2n)	        O(nlog2n)	        O(n)	    稳定	    较复杂    n大时较好
     * 基数排序	    O(n*k)	            O(n*k)	            O(n*k)	            O(n+k)	    稳定	    较复杂
     * 计数排序      O(n+k)              O(n+k)              O(n+k)              O(n+k)      稳定
     * 桶排序        O(n+k)              O(n2)               O(n)                O(n+k)      稳定
     */
}
