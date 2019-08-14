package com.chen.test;

/**
 * 三目运算符 遇到类型不一致的情况，会自动拆包
 *
 * @author :  chen weijie
 * @Date: 2019-05-31 14:43
 */
public class User {

    private Integer id;

    private String userNmae;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public static void main(String[] args) {

        User user = new User();

        Integer i = (user == null) ? -1 : user.getId();
        System.out.println(i);
        System.out.println(i.getClass());
    }
}
