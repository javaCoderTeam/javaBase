package com.chen.api.util.thread.study.chapter2.dirtyRead;

/**
 * 公共变量
 *
 * @author chen weijie
 * @date 2018-04-12 11:55 PM
 */
public class PublicVar {

    public String userName;

    public String passWord;

    synchronized public void setValue(String userName, String passWord) {

        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.passWord = passWord;
            System.out.println("setValue method thread name=" +
                    Thread.currentThread().getName() + ",userName:===" + userName + ",passWord===" + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   synchronized public void getValue() {
        System.out.println("getValue method thread name=" +
                Thread.currentThread().getName() + ",userName:===" + userName + ",passWord===" + passWord);

    }


}
