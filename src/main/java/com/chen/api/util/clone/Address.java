package com.chen.api.util.clone;

/**
 * @author :  chen weijie
 * @Date: 2020-07-23 16:06
 */
public class Address implements Cloneable {

    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public Object clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }

}
