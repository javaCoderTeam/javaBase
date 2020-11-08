package com.chen.algorithm.znn.bitmap;

/**
 * @Auther: zhunn
 * @Date: 2020/10/24 17:23
 * @Description: 位运算相关
 */
public class Test {
    /*
    位运算操作：
    1、 x & 1 == 1 or x & 1 == 0 判断奇偶（x % 2 == 1）
    2、 x = x & (x-1)   =>清零最低位的 1,即将最低位的1设置为0
    3、 x & -x  => 得到最低位的 1
    4、任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
    5、任何数和其自身做异或运算，结果是 0，a⊕a=0。
    6、异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    */
}
