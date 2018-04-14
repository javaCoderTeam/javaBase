package com.chen.api.util.thread.study.chapter2.synBlockingString;

import com.chen.api.util.thread.study.chapter2.throwExceptionNoLock.ThreadB;

/**
 * @author chen weijie
 * @date 2018-04-15 2:26 AM
 */
public class Service {

    private String userNameParam;

    private String passWordParam;

    private String anyString = new String();

    public void setUserNamePassword(String userName, String passWord) {

        try {
//    使用synchronized(非this对象X)同步代码块格式进行同步时,对象监视器必须是同一个对象
//    如果使用非同一个对象达不到同步的效果
//            String anyString = new String();
            synchronized (anyString) {
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                userNameParam = userName;
                Thread.sleep(3000);
                passWordParam = passWord;
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
