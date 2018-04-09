package com.chen.api.util.thread.study.chapter1.notSafeThread;

/**
 * 非线程安全的示例,run中的代码被多个用户去访问，导致的是线程不安全
 *
 * @author Chen WeiJie
 * @date 2018-04-09 16:09
 **/
public class NotSafeThreadServlet {


    private static String userNameStr;

    private static String passWordStr;

    public static void doPost(String userName, String passWord) {
        try {
            userNameStr = userName;
            if (userName.equals("a")) {
                Thread.sleep(100);
            }
            passWordStr = passWord;

            System.out.println("userName:" + userNameStr + "-------passWord:" + passWordStr);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
