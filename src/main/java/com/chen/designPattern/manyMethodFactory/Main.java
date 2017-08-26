package com.chen.designPattern.manyMethodFactory;

/**
 * Created by chenwj3 on 2017/1/19.
 */
public class Main {

        public static void main(String args[]){

            SendFactory sendFactory=new SendFactory();
            Sender sender1= sendFactory.produceMail();
            sender1.send();
        }

}
