package com.chen.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author :  chen weijie
 * @Date: 2020-06-12 11:48
 */
public class TestJSON {


  static class People {

        Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {


        String json = "{\"age\":\"43\"}";

        People people =JSONObject.parseObject(json,People.class);




    }
}
