package com.chen.api.util.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author :  chen weijie
 * @Date: 2020-04-15 01:30
 */
public class GuavaFilter {


    /**
     * 我们创建了一个最多存放 最多 1500个整数的布隆过滤器，并且我们可以容忍误判的概率为百分之（0.01）
     *
     * @param args
     */
    public static void main(String[] args) {

        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));


    }
}
