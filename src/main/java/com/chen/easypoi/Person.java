package com.chen.easypoi;

//import org.jeecgframework.poi.excel.annotation.Excel;

import java.util.Date;

/**
 * @author chen weijie
 * @date 2018-01-19 12:06 AM
 */
public class Person {
//    @Excel(name = "姓名", orderNum = "0")
    private String name;

//    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    private String sex;

//    @Excel(name = "生日", exportFormat = "yyyy-MM-dd", orderNum = "2")
    private Date birthday;

    public Person(String name, String sex, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
