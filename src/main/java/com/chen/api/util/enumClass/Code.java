package com.chen.api.util.enumClass;

/**
 * Created by Chen Weijie on 2017/7/16.
 */
public enum Code {

    春天("spring",1),
    夏天("summer",2),
    秋天("autumn",3),
    冬天("winter",4);

    private String name ;

    private int sort;

    Code(String name,int sort){

        this.name =name;
        this.sort=sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
