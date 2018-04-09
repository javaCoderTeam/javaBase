package com.chen.api.util.thread.study.chapter1.stopThrowLock;

/**
 * @author chen weijie
 * @date 2018-04-10 1:14 AM
 */
public class SynchronizedObject {


    private String userName ="a";

    private String passWord="aa";


   synchronized public void printString(String userName,String passWord){

        this.userName =userName;
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.passWord=passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
