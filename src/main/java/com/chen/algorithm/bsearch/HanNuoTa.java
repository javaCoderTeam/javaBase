package com.chen.algorithm.bsearch;

/**
 * @author :  chen weijie
 * @Date: 2020-05-02 11:56
 */
public class HanNuoTa {

    /**
     * 汉诺塔问题
     *
     * @param dish 盘子个数
     * @param from 初始塔数
     * @param temp 中介塔数
     * @param to   目标塔数
     */
    public static void move(int dish, String from, String temp, String to) {

        if (dish == 1) {
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
        } else {
            //A为初始塔，B为目标塔，C为中介塔
            move(dish - 1, from, to, temp);
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
            //B为初始塔，C为目标塔，A是中介塔
            move(dish - 1, temp, from, to);
        }
    }


    public static void main(String[] args) {

        move(4, "A", "C", "B");
    }
}
